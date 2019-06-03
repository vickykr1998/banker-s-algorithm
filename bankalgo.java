import java.util.*;
import java.io.*;

public class bankers{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,m;
		System.out.println("enter the number of process & length of process");
		n=sc.nextInt();
		m=sc.nextInt();

		int need[][]=new int [n][m];
		int alloc[][]=new int [n][m];
		int max[][]=new int [n][m];
		int work[]=new int [m];
		boolean visited[]=new boolean[n];
		System.out.println("enter the allocations");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				alloc[i][j]=sc.nextInt();
			}
		}
		System.out.println("enter the max");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				max[i][j]=sc.nextInt();
			}
		}
		System.out.println("enter the available");
		for(int i=0;i<m;i++)
			work[i]=sc.nextInt();

		System.out.println("need matrix is");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				need[i][j]=max[i][j]-alloc[i][j];
				System.out.println(need[i][j]);
			}
		}
		for(int i=0;i<m;i++)
			visited[i]=false;

		int count=0;
		
        int safe[]=new int[n];
		while(count < n){
             boolean flag=false;
             int k;
			for(k=0;k<n;k++){
				if(visited[k]==false){
                     int l;
					for(l=0;l<m;l++){
						if(need[k][l]>work[l])
							break;
					}
					if(l==m){
						safe[count++]=k;
						visited[k]=true;
						flag=true;
					
					for(int i=0;i<m;i++)
						work[i]=work[i]+alloc[k][i];
				}
			}

		}
		if(flag==false)
			break;
	}
	if(count < n){
		System.out.println("system is not in safe state");

	}
	else{
		     
        System.out.println("Following is the SAFE Sequence"); 
                for (int i = 0;i < n; i++) 
        { 
            System.out.print("P" + safe[i]); 
            if (i != n-1) 
            System.out.print(" -> "); 
        } 
    }
	}
		
	}
