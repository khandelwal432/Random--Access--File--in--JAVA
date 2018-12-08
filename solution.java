package da;
import java.io.*;
import java.util.Scanner;

	
public class solution {
	public static boolean check(int n) {

		int c = 0, q=n;
        for (int i = 2; c < 2 && i * i <= n; i++)    
            while (n % i == 0){ 
                n /= i;  
                c++; 
                } 
        if (n > 1) 
            c++; 
        if (c==2)
        {
        	double r=Math.sqrt(q);
        	if((r-Math.floor(r))==0)
        		return false;
        	return true;
        }
        else
        	return false;			
	}
	public static void main(String args[]) throws IOException
	{
	try {
		RandomAccessFile raf= new RandomAccessFile("a.txt","rw");
		int b;
//		DataInputStream din= new DataInputStream(System.in);
		Scanner sc = new Scanner(System.in);
		int c=0;
		while((b=sc.nextInt())!=-1)
		{
			raf.writeInt(b);
			c++;
		}
		long cc=0;
		int cd=0;
		int count=0;
		while(cd<c)
		{
			raf.seek(cc);
			int ch = raf.readInt();
			if(check(ch))
			{
//				raf.writeLong(0);
				raf.seek(cc);
				raf.writeInt(0);
				count++;
			}
			
			cc=cc+4;
			cd++;
			
		}
		System.out.println(count);
		raf.close();
		sc.close();
	}catch(Exception e) {}
	
	}

}
