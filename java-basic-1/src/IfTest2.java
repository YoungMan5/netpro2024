//IfTest2 xが7,8,9ながbignumber
//xが4,5,6ならmiddle number
//xが1,2,3ならsmall numberを表示するプログラムを書け


public class IfTest2 {
	public static void main(String[] args) { 
		int x=Integer.parseInt(args[0]);
		if(x>=7){
			System.out.println(x+" is Big Number");
		}
	/*ここにelse if文を追加する。**/
	    else if(4<=x&&x<=6){
            System.out.println(x+" is Middle number");
        }
        else if(1<=x){
            System.out.println(x+" is Small number");
        }

	}//main end
}//class end