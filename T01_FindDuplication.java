package offer;

public class T01_FindDuplication{
	
	//�ҳ��������ظ�������
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
	
	
	//���޸����飬�ҳ��ظ�����
	public int getDuplicate(int[] numbers)
	{
		//�ж������Ƿ�Ϊ��
		if(numbers==null||numbers.length<=0)
		{
			System.out.println("����������Ч��");
			return -1;
		}
		
		//�ж������Ƿ�Խ��
		int length=numbers.length;
		for (int a:numbers) {
			if(a<0||a>length-1) {
				System.out.println("���ִ�С������Χ��");
				return -1;
			}
		}
		
		//���ַ����������ظ�����
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
		System.out.println("���������ظ����֣�");
		return -1;
	}
	//ͳ�����������ֵ���Ŀ
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
	
	//===============================���Դ���==================================
	
	/*����Ϊnull*/
	public void test1() {
		System.out.println("test1:");
		int[] a=null;
		boolean res=duplicate(a);
		System.out.println("�����ظ����֣�"+res);
		int dup=getDuplicate(a);
		if (dup>=0)
			System.out.println("�ظ�����Ϊ��"+dup);
	}

	/*�������ظ�����*/
	public void test2() {
		System.out.println("test2:");
		int[] a= {0,1,2,3};
		boolean res=duplicate(a);
		System.out.println("�����ظ����֣�"+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("�ظ�����Ϊ��"+dup);
		
	}
	
	/*��������Խ��*/
	public void test3() {
		System.out.println("test3:");
		int[] a= {1,2,3,4};
		boolean res=duplicate(a);
		System.out.println("�����ظ����֣�"+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("�ظ�����Ϊ��"+dup);
	}
	
	/*������ظ�����*/
	public void test4() {
		System.out.println("test4");
		int[] a= {1,2,3,2,4};
		boolean res=duplicate(a);
		System.out.println("�����ظ����֣�"+res);
		int dup=getDuplicate(a);
		if(dup>=0)
			System.out.println("�ظ�����Ϊ��"+dup);
	}
}