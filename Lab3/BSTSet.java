public class BSTSet {
	
	private TNode root;
	
	public BSTSet()
	{
		root=null;
	}
	public BSTSet(int[] input)
	{
		mergeSort(input, input.length);
		int[] newArray=removedup(input);
		int mid=newArray.length/2;
		root = new TNode(newArray[mid], null, null);
		 leftbranch(root, 0, mid,newArray);
		 rightbranch(root, mid+1, newArray.length, newArray);
	}
	//constructor end////////////////////////////////////////////////////////
	public void leftbranch(TNode parent, int start, int end, int[] input)
	{
		if(start==end)
		 {
			return;
		 }
		int mid=(end-start+1)/2;
		parent.left = new TNode(input[mid], null, null);
		leftbranch(parent.left, 0, mid,input);
		rightbranch(parent.left, mid+1, (end-start+1), input);
	}
	public void rightbranch(TNode parent, int start, int end, int[] input)
	{
		if(start>end)
		 {
			return;
		 }
		int mid=(end-start+1)/2;
		parent.right = new TNode(input[mid], null, null);
		leftbranch(parent.right, 0, mid,input);
		rightbranch(parent.right, mid+1, (end-start+1), input);
	}
	public boolean isIn(int v)
	{
		if(root==null)
		 {
			return false;
		 }
		TNode index=root;
		while(1>0)
		 {
			if((index.element)<v)
			 {  
				if(index.right==null)
				 {
					return false;
				 }
				index=index.right;
				continue;
			 }
			if((index.element)>v)
			 {
				if(index.left==null)
				 {
					return false;
				 }
				index=index.left;
				continue;
			 }
			if((index.element)==v)
			 {
				return true;
			 }
		 }
	}//class isIn end///////////////////////////////////////////////////
	public void add(int v)
	{
		if(root==null)
		 {
			root=new TNode(v, null, null);
		 }
		TNode index=root;
		if(isIn(v)==false)
		 {
			while(1>0)
			 {
				if((index.element)<v)
				 {  
					if(index.right==null)
					 {
						index.right=new TNode(v, null, null);
						break;
					 }
					index=index.right;
					continue;
				 }
				if((index.element)>v)
				 {
					if(index.left==null)
					 {
						index.left=new TNode(v, null, null);
						break;
					 }
					index=index.left;
					continue;
				 }
				
			 }//while loop end
		 }//if loop end
	}//class add end////////////////////////////////////////////////////////
	public boolean remove(int v)
	{
		if (root == null) 
		 {
            return false;
         }
		TNode index=root;
		if(isIn(v)==true)
		 {
			while(1>0)
			 {
				if((index.element)<v)
				 {  
					index=index.right;
					continue;
				 }
				if((index.element)>v)
				 {
					index=index.left;
					continue;
				 }
				if((index.element)==v)
				 {
					break;
				 }
			 }	
			//First scenario: the node is a leaf
			if((index.left==null)&&(index.right==null))
			 {
				index=null;
			 }
			//Second scenario: the node have only one child
			if((index.left!=null)&&(index.right==null)||(index.left==null)&&(index.right!=null))
			 {
				if(index.left!=null)
				 {
					index=index.left;
				 }
				else
				 {
					index=index.right;
				 }
			 }
			//Third scenario
			TNode temp=index;
			temp=temp.right;
			while(1>0)
			 {
				if(temp.left!=null)
				 {
					temp=temp.left;
					continue;
				 }
				else
				 {
					break;
				 }
			 }
			index=temp;
			temp=null;
			return true; 
		 }//end of if loop
		return false;
	}//class remove end/////////////////////////////////////////////////
	public BSTSet union(BSTSet s) 
	{
        if (this.root == null) 
         {
            return s;
         } 
        if (s.root == null) 
         {
            return this;
         }
        int thisize=size(this.root);
        int ssize=size(s.root);
        int[] thisArr=arrIncrease(this.root);
        int[] sArr=arrIncrease(s.root);
        int[] combined= new int[(thisize+ssize)];
        for(int i=0; i<thisize; i++)
         {
        	combined[i]=thisArr[i];
         }
        int j=(thisize+1);
        for(int i=0; i<ssize; i++)
         {
       	    combined[j]=sArr[i];
       	    j++;
         }
        mergeSort(combined, combined.length);
        int[] newArr=removedup(combined);
        BSTSet output=new BSTSet(newArr);
        return output;
      
    }//class union end////////////////////////////
	public BSTSet intersection(BSTSet s)
	{
	   if (this.root == null) 
        {
		   BSTSet out=new BSTSet();
           return out;
        } 
       if (s.root == null) 
        {
    	   BSTSet out=new BSTSet();
           return out;
        }
       int thisize=size(this.root);
       int ssize=size(s.root);
       int[] thisArr=arrIncrease(this.root);
       int[] sArr=arrIncrease(s.root);
       int[] combined= new int[(thisize+ssize)];
       for(int i=0; i<thisize; i++)
        {
       	combined[i]=thisArr[i];
        }
       int j=(thisize+1);
       for(int i=0; i<ssize; i++)
        {
      	    combined[j]=sArr[i];
      	    j++;
        }
       mergeSort(combined, combined.length);
       int Lidx=0;
   	   int Ridx=1;
   	   int[] arr=new int[combined.length];
   	   int i=0;
   	while(Ridx<=(combined.length-1))
   	 {
   		if(combined[Lidx]==combined[Ridx])
   		 {
   			arr[i]=combined[Ridx];
   			i++;
   		 }
   		Lidx+=2;
   		Ridx+=2;
   	 }
   	int[] ultiArr=new int[i+1];
   	for(int k=0; k<=i; k++)
   	 {
   		ultiArr[k]=arr[k];
   	 }
   	BSTSet output=new BSTSet(ultiArr);
    return output;
       
	}//class intersection end///////////////////////////////////
	public BSTSet difference(BSTSet s)
	{
		if (this.root == null) 
        {
		   BSTSet out=new BSTSet();
           return out;
        } 
       if (s.root == null) 
        {
           return this;
        }
       int thisize=size(this.root);
       int ssize=size(s.root);
       int[] thisArr=arrIncrease(this.root);
       int[] sArr=arrIncrease(s.root);
       int[] combined= new int[(thisize+ssize)];
       for(int i=0; i<thisize; i++)
        {
       	combined[i]=thisArr[i];
        }
       int j=(thisize+1);
       for(int i=0; i<ssize; i++)
        {
      	    combined[j]=sArr[i];
      	    j++;
        }
       mergeSort(combined, combined.length);
       int Lidx=0;
   	   int Ridx=1;
   	   int[] arr=new int[combined.length];
   	   int i=0;
   	while(Ridx<=(combined.length-1))
   	 {
   		if(combined[Lidx]==combined[Ridx])
   		 {
   			arr[i]=combined[Ridx];
   			i++;
   		 }
   		Lidx+=2;
   		Ridx+=2;
   	 }
   	int[] ultiArr=new int[i+1];
   	for(int k=0; k<=i; k++)
   	 {
   		ultiArr[k]=arr[k];
   	 }
   	int outer=0;
   	int counter=0;
   	int[] outArr=new int[thisize-ultiArr.length];
   	for(int inner=0; inner<ultiArr.length; inner++)
   	 {
   		while(outer<outArr.length)
   		 {
   			if((ultiArr[inner])==(thisArr[outer]))
   			 {
   				outer++;
   				break;
   			 }
   			else
   			 {
   				outArr[counter]=thisArr[outer];
   				outer++;
   				counter++;
   			 }
   		 }
   	 }
   	
   	BSTSet output=new BSTSet(outArr);
    return output;
	}//class difference end///////////////////////////////////
	
	public int height() 
	{
        if (root==null) 
         {
            return -1;
         }
        return height(root);
    }
    private int height(TNode t) 
    {
        if (t == null) 
        {
            return -1;
        }

        return 1 + Math.max(height(t.left), height(t.right));
    }
	
	
    public int size() 
    {
        return size(root);
    }
    private int size(TNode t) 
    {
        if (t == null) 
        {
            return 0;
        }

        return size(t.left) + 1 + size(t.right);
    }
	
	public void printBSTSet() {
        if (root == null) {
            System.out.println("The set is empty");
        } else {
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }

    private void printBSTSet(TNode t) {
        if (t != null) {
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }
	public TNode getRoot()
	{
		return root;
	}
	
	
	
	
//Assist Class
    private int[] arrIncrease(TNode t) 
    {
    	int size=size(t);
    	int counter=0;
    	int[] arr=new int[size];
    	int var;
        if(t != null) 
         {
        	arrIncrease(t.left);
            var=t.element;
            while(counter<size)
             {
            	arr[counter]=var;
            	counter++;
            	break;
             }
            arrIncrease(t.right);
         }
        return arr;
    }

    
    
	
	public void mergeSort(int[] arr, int length) 
	{
	    if (length < 2) 
	     {
	        return;
	     }
	    int mid=length/2;
	    int[] left=new int[mid];
	    int[] right=new int[length - mid];

	    for(int i=0; i<mid; i++) 
	     {
	        left[i]=arr[i];
	     }
	    for (int i=mid; i<length; i++) 
	     {
	        right[i-mid]=arr[i];
	     }
	    mergeSort(left, mid);
	    mergeSort(right, length-mid);

	    merge(arr, left, right, mid, length-mid);
	}
	
    public int[] removedup(int[] sortedArr)
    {
    	int Lidx=0;
    	int Ridx=1;
    	int[] arr=new int[sortedArr.length];
    	int i=0;
    	while(Ridx<=(sortedArr.length-1))
    	 {
    		if(sortedArr[Lidx]==sortedArr[Ridx])
    		 {
    			arr[i]=sortedArr[Ridx];
    			i++;
    		 }
    		else
    		 {
    			arr[i]=sortedArr[Lidx];
    			arr[i+1]=sortedArr[Ridx];
    			i+=2;
    		 }
    		Lidx+=2;
    		Ridx+=2;
    	 }
    	return arr;
    }
	
	
}//whole class end