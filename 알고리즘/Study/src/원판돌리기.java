import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//원판돌리기//
public class 원판돌리기 {
	
	static int delx[]={0,0,1,-1};
	static int dely[]={1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int result=0;
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		int T=Integer.parseInt(stk.nextToken());
		ArrayList<Integer>[] list= new ArrayList[N+1];
		ArrayList<Integer>[] clist= new ArrayList[N+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList();
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i].add(Integer.parseInt(stk.nextToken()));
			}
		}
		for (int i = 0; i < T; i++) {
			boolean flag=true;
			double sum=0;
			int ct=0;
			for (int j = 0; j < clist.length; j++) {
				clist[j] = new ArrayList();
			}
			stk=new StringTokenizer(br.readLine());
			int xi=Integer.parseInt(stk.nextToken());
			int di=Integer.parseInt(stk.nextToken());
			int ki=Integer.parseInt(stk.nextToken());
			for (int j = 1; j*xi <= N; j++) {
				if(di==0) {//시계
					for (int k = 0; k < ki; k++) {
						rota1(list[j*xi]);						
					}
				}else {//반시계
					for (int k = 0; k < ki; k++) {
						rota2(list[j*xi]);						
					}
				}
			}
			for (int j = 1; j <= N; j++) {
				clist[j].addAll(list[j]);
			}
			for (int j = 1; j <= N; j++) {
				for (int j2=0 ; j2 < M; j2++) {
					if(clist[j].get(j2)!=0) {
						sum+=clist[j].get(j2);
						ct++;
						for (int k = 0; k < 4; k++) {
							int ni=j+delx[k];
							int nj=j2+dely[k];
							if(nj<0)
								nj=M-1;
							else if(nj>=M)
								nj=0;
							if(ni<1 || ni>N)
								continue;
							if(clist[j].get(j2)==clist[ni].get(nj)) {
								list[j].set(j2, 0);
								flag=false;
							}
						}
					}
				}
			}
			if(flag&&ct!=0) {
				sum/=ct;
				for (int i3 = 1; i3 <= N; i3++) {
					for (int j3 = 0; j3 < M; j3++) {
						if(clist[i3].get(j3)==0)
							continue;
						if(clist[i3].get(j3)>sum)
							list[i3].set(j3,clist[i3].get(j3)-1);
						else if(clist[i3].get(j3)<sum)
							list[i3].set(j3,clist[i3].get(j3)+1);
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				result+=list[i].get(j);
			}
		}
		
		System.out.println(result);
	}

	private static void rota2(ArrayList<Integer> list) {
		list.add(list.get(0));
		list.remove(0);
	}

	private static void rota1(ArrayList<Integer> list) {
		list.add(0, list.get(list.size()-1));
		list.remove(list.size()-1);
	}
}