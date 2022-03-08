//Constructor parameters
//Time: theta(1)
//space: 36
public class HashTableQuad
{
	private Integer[] table;
	private int size;
	private int maxNum;
	private int already;
	private double load;
	
	public HashTableQuad(int maxNum, double load)
	{
		this.maxNum=maxNum;                                //specify maxNum
		this.already=0;                                    //specify already
		this.load=load;                                    //specify load
		int check;//check if size is prime number
		check=(int)Math.ceil(maxNum/load);
		this.size=findNextPrime(check);                   //specify size
		this.table = new Integer[this.size];                          //allocate array		
	}//constructor end*****************************************************************
	//Time: theta(n)
	//space: 8
	public int findNextPrime(int n)
	{
		while(0<1)
		  {
			 if(ifPrime(n)==true)
			  {
				 return n;
			  }
			 else
			  {
				 n++;
			  }
		  }
	}
	//Time: theta(1)
	//space: 9
	public boolean ifPrime(int n)
	{
		if((n==2)||(n==3)||(n==5)||(n==7))
		 {return true;}
		if(((n%2)==0)||(n==9))
		 {return false;}
		for(int i=3; i<10; i+=2)
		 {
			if((n%i)==0)
			{return false;}
		 }
		return true;
	}//Class findNextPrime and ifPrime end***********************************************
	//Time: theta(n)
	//space: 4n+40
	public void insert(int num)
	{
    	double dupalready=this.already;
		double dupsize=this.size;
		double currentLoad=(dupalready+1)/(dupsize);
		if(currentLoad>this.load)
		 {
		    rehash();		    
		 }
		
		int counter=0;
		int index=num%this.size;
		while(index>(this.size-1))
  	     {
  		   index=index%this.size;
  	     }
		for(int i=0;i<this.size; i++)
		  {
			if((this.table[index]!=null)&&(this.table[index]!=num))
			 {
				counter++;
		    	index=(int)(index+Math.pow(counter, 2));
		    	while(index>(this.size-1))
		   	     {
		   		   index=index%this.size;
		   	     }
			 }
			else
			 {
				break;
			 }
		  }

		if(this.table[index]==null)
		{
		this.already++;
		}
		this.table[index]=num;
	}//Class insert end*******************************************************
	//Time: theta(n)
	//space: 36
	private void rehash()
	{		
		HashTableQuad temp=new HashTableQuad(2*this.maxNum, this.load);
		for(int i=0; i<this.size; i++)
		 {
			if(this.table[i]!=null)
			{
				temp.insert(this.table[i]);
			}
		 }
		this.table=temp.table;
		this.size=temp.size;
		this.maxNum = 2*temp.maxNum;
		this.already=temp.already;
		this.load=temp.load;
	}//Class rehash end********************************************************
	//Time: theta(n)
	//space: 4n+17
	public boolean isIn(int n)
	{
		int index=n%this.size;
		while(index>(this.size-1))
  	     {
  		   index=index%this.size;
  	     }
		int counter=0;
		for(int i=0; i<this.size; i++)
		 {
			if(this.table[index]!=null)
			 {
				if(this.table[index]!=n)
				 {
					counter++;
					index=(int)(index+Math.pow(counter, 2));
					while(index>(this.size-1))
			   	     {
			   		   index=index%this.size;
			   	     }
				 }
				else
				 {
					return true;
				 }
			 }
			else
			 {
				return false;
			 }
		 }
		return false;
	}//Class isIn end********************************************************
	//Time: theta(n)
	//space: 4n+4
	public void printKeys()
	{
		System.out.print("Keys: ");
		for(int i=0; i<this.size; i++)
	 	 {
			if(this.table[i]!=null)
			 {
				System.out.print(this.table[i]+" ");
			 }
		 }
		System.out.print("\n");
	}//Class printKeys end********************************************************
	//Time: theta(n)
	//space: 4n+4
	public void printKeysAndIndexes()
	{
		System.out.print("Keys and Indexes: ");
		for(int i=0; i<this.size; i++)
	 	 {
			if(this.table[i]!=null)
			 {
				System.out.print("("+i+": "+this.table[i]+") ");
			 }
		 }
		System.out.print("\n");
	}//Class printKeysAndIndexes end********************************************************
	//Time: theta(1)
	//space: 4
	public int getTableSize()
	{
        return this.size;
    }

    public int getNumKeys()
    {
        return this.already;
    }

    public int getMaxNumKeys()
    {
        return this.maxNum;
    }
    
    public double getMaxLoadFactor()
    {
        return this.load;
    }

    public double getCurrentLoadFactor()
    {
        return (double)(this.already/this.size);
    }  
   //**************************************
    //Time: theta(n)
    //space: 4n+48
    public int insertCount(int num)
	{
    	double dupalready=this.already;
		double dupsize=this.size;
		double currentLoad=(dupalready+1)/(dupsize);
		if(currentLoad>this.load)
		 {
		    rehash();		    
		 }
		
		int counter=0;//count insert
		int countpow=0;
		int index=num%this.size;
		while(index>(this.size-1))
   	     {
   		   index=index%this.size;
   	     }
		for(int i=0;i<this.size; i++)
		  {
			if((this.table[index]!=null)&&(this.table[index]!=num))
			 {
				counter++;
				countpow++;
				index=(int)(index+Math.pow(countpow, 2));
				while(index>(this.size-1))
		   	     {
		   		   index=index%this.size;
		   	     }
			 }
			else
			 {
				counter++;
				break;
			 }
		  }
		if(this.table[index]==null)
		{
		this.already++;
		}
		this.table[index]=num;
		return counter;
	}//Class insert end*******************************************************
}//whole class end