public class MaxHeap
{
	private Integer[] heap;
	private int size;
	private int already;
	//Run time: theta(1)
	//Space complexity: 4n+8
	public MaxHeap(int heapSize) //Constructor 1
	{
		this.size=heapSize;
		this.already=0;
		this.heap = new Integer[this.size];
	}
	//Run time: theta(n)/theta(nlogn)
	//Space complexity: 8n+40
	public MaxHeap(Integer[] someArray) //Constructor 2
	{
		this.heap = new Integer[someArray.length];
		this.size=someArray.length;
		this.already=0;
		int index=0;
		for(int i=0; i<someArray.length; i++)
		 {
			if(someArray[i]!=null)
			 {
				this.already++;
				this.heap[index]=someArray[i];
				index++;
			 }
		 }
		buildHeap();
	}
	//constructor end*****************************************************************
	//Run time: theta(n)/theta(nlogn)
	//Space complexity: constant (24)
	public void buildHeap()
	{		
		int maxIndex;
		if((this.already%2)==0)
		 {
			maxIndex=(this.already-2)/2;
		 }
		else
		 {
			maxIndex=(this.already-3)/2;
		 }
		
		int count=0;//count if any swap is made
		while(1>0)
		 {
			count=0;
			for(int i=0; i<=maxIndex; i++)
			 {
				int index=i;
				int left=2*index+1;
				int right=2*index+2;
				if(this.heap[left]!=null)
				 {
				   if(this.heap[i]<this.heap[left])
				    {
					  swap(i, left);
					  count++;
				    }
				 }
				 if((right<this.already)&&(this.heap[right]!=null))
				  {
				    if(this.heap[i]<this.heap[right])
				     {
					   swap(i, right);
					   count++;
				     }
				  }
				 
			 }
			if(count==0)
			 {
				break;
			 }
		 }
		
	}// Class buildHeap end*****************************************************************
	//Run time: theta(1)
	//Space complexity: constant (12)
	public void swap(int index1, int index2)
	{
		int temp = this.heap[index1];
        this.heap[index1] = this.heap[index2];
        this.heap[index2] = temp;
	}// Class swap end*****************************************************************
	//Run time: theta(n)/theta(nlogn)
	//Space complexity: 8n+88
	public void insert(int n)
	{
		if((this.already+1)>this.size)
		 {
			MaxHeap temp=new MaxHeap(this.size*2);
			int index=0;
			for(int i=0; i<this.size; i++)
			 {
				if(this.heap[i]!=null)
				 {
					temp.already++;
					temp.heap[index]=this.heap[i];
					index++;
				 }
			 }
			temp.heap[index]=n;
			temp.already++;
			this.size=temp.size;
			this.already=temp.already;
			this.heap=temp.heap;
		 }
		else
		 {
			this.heap[this.already]=n;
			this.already++;
		 }
		buildHeap();
	}// Class insert end*****************************************************************
	//Run time: theta(n)/theta(nlogn)
	//Space complexity: 4n+48
	private int deleteMax()
	{
		if((this.already-1)==0)
		 {
			int output=this.heap[0];
			this.already=0;
			this.heap[0]=null;
			return output;
		 }
		int output=this.heap[0];
		this.heap[0]=this.heap[this.already-1];
		this.heap[this.already-1]=null;
		MaxHeap temp=new MaxHeap(this.already-1);
		this.already--;
		for(int i=0; i<this.already; i++)
		 {
			temp.heap[i]=this.heap[i];
		 }
		this.heap=temp.heap;
		buildHeap();
		return output;
	}// Class delete end*****************************************************************
	//Run time: n
	//Space complexity: 4n+4
	public String toString()
	{
		String output = new String();
		for(int i=0; i<this.already; i++)
		 {
			if(this.heap[i]!=null)
			 {
			   output=output+this.heap[i]+",";
			 }
		 }
		return output;
	}// Class toString end*****************************************************************
	//Run time: theta(n^2)/theta(n^2*logn)
	//Space complexity: 16n+92
	public static void heapsort(Integer[] arrayToSort)
	{
		int i=0;
		MaxHeap temp=new MaxHeap(arrayToSort);
		while(temp.already!=0)
		 {
			arrayToSort[i]=temp.deleteMax();
			i++;
		 }
	}// Class heapsort end*****************************************************************
	//Run time: theta(1)
	//Space complexity: constant (4)
	public int getSizeArr()
	{
		return this.size;
	}
	public int getSizeHeap()
	{
		return this.already;
	}
	public Integer[] getHeap() 
	{
        return this.heap;
    }
	
}// Whole class end