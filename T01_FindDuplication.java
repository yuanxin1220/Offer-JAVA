package offer;

public class T01_FindDuplication{
	
	//找出数组中重复的数字
	public boolean duplicate(int[] numbers) {
		if(numbers==null||numbers.length<=0)
			return false;
		int length=numbers.length;
		for(int i =0;i<length;++i) {
			if (numbers[i]<0||numbers[i]>length-1)
				return false;
		}
		for(int i=0;i<length;++i)
		{
			while(numbers[i]!=i)
			{
				if(numbers[i]==numbers[numbers[i]])
				{
					int duplication=numbers[i];
					System.out.println(duplication);
					return true;
				}
				//swap numbers[i] and numbers[numbers[i]]
				int temp=numbers[i];
				numbers[i]=numbers[temp];
				numbers[temp]=temp;
				
			}
		}
		return false;
	}
	
	
	//不修改数组，找出重复数字
	public int getDuplicate(int[] numbers)
	{
		//判定数组是否为空
		if(numbers==null||numbers.length<=0)
		{
			System.out.println("数组输入无效！");
			return -1;
		}
		
		//判定数组是否越界
		int length=numbers.length;
		for (int a:numbers) {
			if(a<0||a>length-1) {
				System.out.println("数字大小超出范围！");
				return -1;
			}
		}
		
		//二分法查找有无重复数字
		int start=1;
		int end=length-1;
		while(end>=start)
		{
			int middle=((end-start)>>1)+start;
			int count=countRange(numbers,length,start,middle);
			if(end==start)
			{
				if(count>1)
					return start;
				else
					break;
			}
			if(count>(middle-start+1))
				end=middle;
			else
				start=middle+1;
		}
		System.out.println("数组中无重复数字！");
		return -1;
	}
	//统计区间里数字的数目
	public int countRange(int[] numbers,int length,int start,int end)
	{
		if(numbers==null)
			return 0;
		int count=0;
		for(int i=0;i<length;i++) {
			if(numbers[i]>=start&&numbers[i]<=end)
				++count;
		}
		return count;
	}
	
	//===============================测试代码==================================
	
	/*数组为null*/
	public void test1() {
		System.out.println("test1:");
		int[] a=null;
		boolean res=duplicate(a);
		System.out.println("有无重复数字："+res);
		int dup=getDuplicate(a);
		if (dup>=0)
			System.out.println("重复数字为："+dup);
	}

	/*数组无重复数字*/
	public void test2() {
		System.out.println("test2:");
		int[] a= {0,1,2,3};
		boolean res=duplicate(a);
		System.out.println("有无重复数字："+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("重复数字为："+dup);
		
	}
	
	/*数组数字越界*/
	public void test3() {
		System.out.println("test3:");
		int[] a= {1,2,3,4};
		boolean res=duplicate(a);
		System.out.println("有无重复数字："+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("重复数字为："+dup);
	}
	
	/*数组带重复数字*/
	public void test4() {
		System.out.println("test4");
		int[] a= {1,2,3,2,4};
		boolean res=duplicate(a);
		System.out.println("有无重复数字："+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("重复数字为："+dup);
	}
}