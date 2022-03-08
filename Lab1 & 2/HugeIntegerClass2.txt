import java.util.Random;
public class HugeInteger
{
	 private int[] HugeIntArray;
	 private int negsign;
	 private int size;
	 ///Constructor/////////////////////////////////////////////
     public HugeInteger(String val)//constructor 1
     {
    	 int length=val.length();
    	 char sign=val.charAt(0);//get the first digit of val
    	 String neg="-";
    	 char negative=neg.charAt(0);
    	 int digit;//represent the digit of val

    	 if(((val.length()==1)&&(Character.isDigit(val.charAt(0))==false))||((Character.isDigit(val.charAt(0))==false)&&(sign!=negative)))
    	  {
    		 throw new IllegalArgumentException("Invalid Inp");
    	  }
    	// ********************
    	 if(sign==negative)//#1
    	  {
    		 int ifzero=0;
    		 for(int i=1; i<=(length-1); i++)
    		   {
    			 if(Character.isDigit(val.charAt(i))==false)
    			  {
    				 throw new IllegalArgumentException("Invalid Inputt");
    			  }
    			 if((Character.getNumericValue(val.charAt(0))==0)&&(val.length()!=2))
    			  {
    				 ifzero=1;
    			  }
    			 if(ifzero==1)
    			  {
    				 throw new IllegalArgumentException("Invalid Inputss");
    			  }
    			 if(ifzero==0)
    			  {
    				 break;
    			  }
    		   }
    		 
    		 this.size=length-1;
    		 int arr[]= new int[length-1];//same array as HugeIntArray
    		 this.negsign=1;//mark the negtive sign
    		 for(int i=1; i<=(length-1); i++)
      	       {
    			 if(Character.isDigit(val.charAt(i))==false)
    			  {
    				 throw new IllegalArgumentException("Invalid Inpuuuu");
    			  }
    			 digit=Character.getNumericValue(val.charAt(i));
    			 arr[i-1]=digit;
      	       }
    		 this.HugeIntArray=arr;
    	  }
    	 if(sign!=negative)//#2
    	  {
    		 
    		   if((Character.getNumericValue(val.charAt(0))==0)&&(val.length()!=1))
			    {
    			 throw new IllegalArgumentException("Invalid Inpussssss");
			    }
    		 
    		 this.size=length;
    		 int arr[]= new int[length];//same array as HugeIntArray
    		 this.negsign=0;//mark the negtive sign
    		 for(int i=0; i<=(length-1); i++)
      	       {
    			 if(Character.isDigit(val.charAt(i))==false)
   			      {
   				     throw new IllegalArgumentException("Invalid Inputssrrrr");
   			      }
    			 digit=Character.getNumericValue(val.charAt(i));
    			 arr[i]=digit;
      	       }
    		 this.HugeIntArray=arr;
    	  }
	
     }
     public HugeInteger(int n)//constructor 2
     {
    	 if(n<=0)
    	  {
    		 throw new IllegalArgumentException("Invalid I");
    	  }
    	 Random rand = new Random();
    	 this.size=n;
    	 this.negsign=0;
    	 int bit;
    	 int arr[]= new int[n];
    	 for(int i=0; i<n; i++)
    	   {
    		 bit = rand.nextInt(10);
    		 arr[i]=bit;
    	   }
    	 this.HugeIntArray=arr;
     }
     
     
     
     
     ///Constructor End*********************************************
     
     public HugeInteger add(HugeInteger h) 
     {
    	 if(((this.negsign==0)&&(h.negsign==0))||((this.negsign==1)&&(h.negsign==1)))//First scenario end: both positive/both negative
    	  {
    		 int hold;
        	 int currentbit;
        	 int nextbit=0;
        	 String tostr;//change hold to string format
        	 String resultinreverse = new String();

        	 if(this.size>=h.size)
        	 {
    		 for(int i=(h.size-1); i>=0; i--)//deal with the PART that both have same length
    		   {
    			  hold=h.HugeIntArray[i]+this.HugeIntArray[i+(this.size-h.size)]+nextbit;
    			  if(hold>=10)
    			   {
    				  tostr=Integer.toString(hold);
    				  currentbit=Character.getNumericValue(tostr.charAt(1));
    				  nextbit=Character.getNumericValue(tostr.charAt(0));
    				  resultinreverse=resultinreverse+currentbit;				  
    			   }
    			  if(hold<10)
    			   {
    				  tostr=Integer.toString(hold);
    				  currentbit=Character.getNumericValue(tostr.charAt(0));
    				  nextbit=0;
    				  resultinreverse=resultinreverse+currentbit;
    			   }
    		   }
        	 }
        	 if(h.size>this.size)
        	 {
    		 for(int i=(this.size-1); i>=0; i--)//deal with the PART that both have same length
    		   {
    			  hold=h.HugeIntArray[i+(h.size-this.size)]+this.HugeIntArray[i]+nextbit;
    			  if(hold>=10)
    			   {
    				  tostr=Integer.toString(hold);
    				  currentbit=Character.getNumericValue(tostr.charAt(1));
    				  nextbit=Character.getNumericValue(tostr.charAt(0));
    				  resultinreverse=resultinreverse+currentbit;				  
    			   }
    			  if(hold<10)
    			   {
    				  tostr=Integer.toString(hold);
    				  currentbit=Character.getNumericValue(tostr.charAt(0));
    				  nextbit=0;
    				  resultinreverse=resultinreverse+currentbit;
    			   }
    		   }
        	 }
    		 if((this.size==h.size)&&(nextbit!=0))//same length, no spare part
    		  {	 
    			 resultinreverse=resultinreverse+nextbit;
    		  }
    		 if(this.size>h.size)//deal with spare part
    		  {  			 
    			 for(int i=(this.size-h.size-1); i>=0; i--)
    			   {
    				 hold=this.HugeIntArray[i]+nextbit;
    				 if(hold>=10)
      			      {
      				   tostr=Integer.toString(hold);
      				   currentbit=Character.getNumericValue(tostr.charAt(1));
      				   nextbit=Character.getNumericValue(tostr.charAt(0));
      				   resultinreverse=resultinreverse+currentbit;				  
      			      }
      			     if(hold<10)
      			      {
      				   tostr=Integer.toString(hold);
      				   currentbit=Character.getNumericValue(tostr.charAt(0));
      				   nextbit=0;
      				   resultinreverse=resultinreverse+currentbit;
      			      }
    			   }
    			 if(nextbit!=0)
    			  {
    				 resultinreverse=resultinreverse+nextbit;
    			  }
    		  }
    		 if(this.size<h.size)//deal with spare part
    		  {
    			 
    			 for(int i=(h.size-this.size-1); i>=0; i--)
  			       {
  				     hold=h.HugeIntArray[i]+nextbit;
  				     if(hold>=10)
    			      {
    				    tostr=Integer.toString(hold);
    				    currentbit=Character.getNumericValue(tostr.charAt(1));
    				    nextbit=Character.getNumericValue(tostr.charAt(0));
    				    resultinreverse=resultinreverse+currentbit;				  
    			      }
    			     if(hold<10)
    			      {
    				    tostr=Integer.toString(hold);
    				    currentbit=Character.getNumericValue(tostr.charAt(0));
    				    nextbit=0;
    				    resultinreverse=resultinreverse+currentbit;
    			      }
  			       }
    			 if(nextbit!=0)
   			      {
   				    resultinreverse=resultinreverse+nextbit;
   			      }
    		  }	
    		 //Below: reverse the result into correct order
    		 int resultsize;
    		 resultsize=resultinreverse.length();
    		 String result = new String();
    		 if((this.negsign==1)&&(h.negsign==1))
    		  {
    			 result=result+"-";
    			 for(int i=(resultsize-1); i>=0; i--)
    			   {
    				 result=result+Character.getNumericValue(resultinreverse.charAt(i));
    			   }
    		  }
    		 if((this.negsign==0)&&(h.negsign==0))
   		      {
   			    for(int i=(resultsize-1); i>=0; i--)
   			      {
   				    result=result+Character.getNumericValue(resultinreverse.charAt(i));
   			      }
   		      }
    		 HugeInteger output = new HugeInteger(result);
        	 return output;
    	  }//First scenario end: both positive/both negative
    	 if(((this.negsign==1)&&(h.negsign==0))||((this.negsign==0)&&(h.negsign==1)))//second scenario: one pos,one neg
    	  {
    		 
    		    int arrthis[]= new int[this.size];
				for(int i=0; i<this.size; i++)
				  {
					 arrthis[i]=this.HugeIntArray[i];
				  }
				int arrh[]= new int[h.size];
				for(int j=0; j<h.size; j++)
				  {
					 arrh[j]=h.HugeIntArray[j];
				  }
    		 
    		 int currentbit;
    		 String resultinreverse = new String();
    		 int counter=0;//count how many bits I've run through
    			 if(this.size>h.size)//#1
    			 {

    				 
    				for(int i=(h.size-1); i>=0; i--)//the part that both array have same length
    				  {
    					
    					counter++;
    					if(this.HugeIntArray[i+(this.size-h.size)]>=h.HugeIntArray[i])//if the bit I am currently operating:above>below
    					 {
    						currentbit=this.HugeIntArray[i+(this.size-h.size)]-h.HugeIntArray[i];
    						resultinreverse=resultinreverse+currentbit;
    					 }
    					if(this.HugeIntArray[i+(this.size-h.size)]<h.HugeIntArray[i])//if the bit I am currently operating:above<below
    					 {
    						
    						int j=this.size-counter-1;
    						if(j!=-1)
    						{
    							if(this.HugeIntArray[j]!=0)//the next bit of the above one is not 0
       						 {
       							this.HugeIntArray[j]=this.HugeIntArray[j]-1;
       						 }
    						//if(this.HugeIntArray[j]==0)//check if the next bit of the above one is 0
    							else
    						 {
    						  while((this.HugeIntArray[j]==0)&&(j>=1))
    						    {
    							 this.HugeIntArray[j]=9;
    							 j--;
    						    }
    						  this.HugeIntArray[j]=this.HugeIntArray[j]-1;
    						 }
    						
    						currentbit=10-h.HugeIntArray[i]+this.HugeIntArray[i+(this.size-h.size)];
    						resultinreverse=resultinreverse+currentbit;
    						}

    					 }

    				  }
    				
    				for(int i=(this.size-h.size-1); i>=0; i--)//spare part of the longer array
    				 {
    					resultinreverse=resultinreverse+this.HugeIntArray[i];
    				 }
    				
    			 }//#1 end
    			 if(h.size>this.size)//#2
    			 {

     				
    				for(int i=(this.size-1); i>=0; i--)//the part that both array have same length
    				  {
    					counter++;
    					if(h.HugeIntArray[i+(h.size-this.size)]>=this.HugeIntArray[i])//if the bit I am currently operating:above>below
    					 {
    						currentbit=h.HugeIntArray[i+(h.size-this.size)]-this.HugeIntArray[i];
    						resultinreverse=resultinreverse+currentbit;
    					 }
    					if(this.HugeIntArray[i]>h.HugeIntArray[i+(h.size-this.size)])//if the bit I am currently operating:above<below
    					 {
    						int j=h.size-counter-1;
    						if(j!=-1)
    						{
    							if(h.HugeIntArray[j]!=0)//the next bit of the above one is not 0
      						     {
      							    h.HugeIntArray[j]=h.HugeIntArray[j]-1;
      						     }
    						//if(h.HugeIntArray[j]==0)//check if the next bit of the above one is 0
    							else
   						     {
   						       while((h.HugeIntArray[j]==0)&&(j>=1))
   						        {
   							     h.HugeIntArray[j]=9;
   							     j--;
   						        }
   						       h.HugeIntArray[j]=h.HugeIntArray[j]-1;
   						     }
   						    
    						currentbit=10-this.HugeIntArray[i]+h.HugeIntArray[i+(h.size-this.size)];
    						resultinreverse=resultinreverse+currentbit;
    						}
    					 }

    				  }
    				for(int i=(h.size-this.size-1); i>=0; i--)//spare part of the longer array
    				 {
    					resultinreverse=resultinreverse+h.HugeIntArray[i];
    				 }
    				
    			 }//#2 end
    		 if(this.size==h.size)//#3
    		  { 
    			int checkwhobigger=2;
    			for(int i=0; i<h.size; i++)//check which is bigger
    			  {
    				if(this.HugeIntArray[i]>h.HugeIntArray[i])
    				 {
    					checkwhobigger=1;
    					break;
    				 }
    				if(this.HugeIntArray[i]<h.HugeIntArray[i])
   				     {
   					    checkwhobigger=0;
   					    break;
   				     }
    				if(this.HugeIntArray[i]==h.HugeIntArray[i])
  				     {
  					    checkwhobigger=-1;
  					    
  				     }
    			  }
    			if(checkwhobigger==-1)
    			{
    				resultinreverse=resultinreverse+0;
    			}
    			if(checkwhobigger==1)
    			 {
    				
    				
    				for(int i=(h.size-1); i>=0; i--)//the part that both array have same length
  				      {
  					    counter++;
  					    if(this.HugeIntArray[i]>=h.HugeIntArray[i])//if the bit I am currently operating:above>below
  					     {
  						   currentbit=this.HugeIntArray[i]-h.HugeIntArray[i];
  						   if((currentbit!=0)&&(i==0))
  						   {
  						     resultinreverse=resultinreverse+currentbit;
  						   }
  						   if(i!=0)
						   {
						     resultinreverse=resultinreverse+currentbit;
						   }
  					     }
  					    if(this.HugeIntArray[i]<h.HugeIntArray[i])//if the bit I am currently operating:above<below
  					     {
  					    	int j=this.size-counter-1;
  					    	if(j!=-1)
  					    	{
  					    		if(this.HugeIntArray[j]!=0)//the next bit of the above one is not 0
  	    						 {
  	    							this.HugeIntArray[j]=this.HugeIntArray[j]-1;
  	    						 }
  					    		
  					    	//	if(this.HugeIntArray[j]==0)//check if the next bit of the above one is 0
  					    		else
    						     {
    						      while((this.HugeIntArray[j]==0)&&(j>=1))
    						        {
    							     this.HugeIntArray[j]=9;
    							     j--;
    						        }
    						       this.HugeIntArray[j]=this.HugeIntArray[j]-1;
    						     }
  					        
    						currentbit=10-h.HugeIntArray[i]+this.HugeIntArray[i];
    						resultinreverse=resultinreverse+currentbit;
  					    	}

    					 }

  					   }
  									
    				
    				
  				 }
    			if(checkwhobigger==0)
    			 {
    				
    				
    			  for(int i=(this.size-1); i>=0; i--)//the part that both array have same length
  				   {
  					counter++;
  					if(h.HugeIntArray[i]>=this.HugeIntArray[i])//if the bit I am currently operating:above>below
  					 {
  						currentbit=h.HugeIntArray[i]-this.HugeIntArray[i];
  						if((currentbit!=0)&&(i==0))
						   {
						     resultinreverse=resultinreverse+currentbit;
						   }
						   if(i!=0)
						   {
						     resultinreverse=resultinreverse+currentbit;
						   }
						   
  					 }
  					if(this.HugeIntArray[i]>h.HugeIntArray[i])//if the bit I am currently operating:above<below
  					 {
  						int j=h.size-counter-1;
  						if(j!=1)
  						{
  							if(h.HugeIntArray[j]!=0)//the next bit of the above one is not 0
  							 {
  							   h.HugeIntArray[j]=h.HugeIntArray[j]-1;
  							 }
						//if(h.HugeIntArray[j]==0)//check if the next bit of the above one is 0
  							else
						 {
						   while((h.HugeIntArray[j]==0)&&(j>=1))
						     {
							  h.HugeIntArray[j]=9;
							  j--;
						     }
						   h.HugeIntArray[j]=h.HugeIntArray[j]-1;
						 }
						
						currentbit=10-this.HugeIntArray[i]+h.HugeIntArray[i];
						resultinreverse=resultinreverse+currentbit;
  						}
  					 }

  				  }
    			  
    			 		  
    			 }
    			  		  
    		  }//#3 end
    		 
    		 
    		 
 			if((resultinreverse.length()!=1)&&( Character.getNumericValue(resultinreverse.charAt(0))!=0 ))
 			{
 				int howmanybit=0;
 	 			String newreverse = new String();
 				
 			for(int i=resultinreverse.length()-1; i>=0; i--)
 			  {
 				if(  Character.getNumericValue(resultinreverse.charAt(i))==0  )
 				 {
 					howmanybit++;
 				 }
 				if(  Character.getNumericValue(resultinreverse.charAt(i))!=0  )
 				 {
 					break;
 				 }
 			  }
 			if(howmanybit!=0)
			  {
 			   for(int i=0; i<(resultinreverse.length()-howmanybit); i++)
 			     {
 				   newreverse=newreverse+Character.getNumericValue(resultinreverse.charAt(i));
 			     }			
 				resultinreverse=newreverse;
 			  }
 			}
    		 
 			
 			
 			 		   
 			
 			
 			this.HugeIntArray=arrthis;
 			h.HugeIntArray=arrh;
 			
 			
 			
    			//Below: reverse the result into correct order
       		    int resultsize;
       		    resultsize=resultinreverse.length();
       		    String result = new String();
       		    if(((this.size>h.size)&&(this.negsign==1))||((h.size>this.size)&&(h.negsign==1)))//#1
       		     {
       			      result=result+"-";
       			   for(int i=(resultsize-1); i>=0; i--)
       			    {
       				  result=result+Character.getNumericValue(resultinreverse.charAt(i));
       			    }
       		     }
       		    if(((this.size>h.size)&&(h.negsign==1))||((h.size>this.size)&&(this.negsign==1)))//#2
   		         {
   			       for(int i=(resultsize-1); i>=0; i--)
   			        {
   				     result=result+Character.getNumericValue(resultinreverse.charAt(i));
   			        }
   		         }
       		    if(this.size==h.size)//#3
		         {
       		    	int checkwhobigger=2;
        			for(int i=0; i<h.size; i++)//check which is bigger
        			  {
        				if(this.HugeIntArray[i]>h.HugeIntArray[i])
        				 {
        					checkwhobigger=1;
        					break;
        				 }
        			 	if(this.HugeIntArray[i]<h.HugeIntArray[i])
       				     {
       					    checkwhobigger=0;
       					    break;
       				     }
        			 	if(this.HugeIntArray[i]==h.HugeIntArray[i])
       				     {
       					    checkwhobigger=-1;
       					    
       				     }
        			  }
		           if((checkwhobigger==1)&&(this.negsign==1)&&(h.negsign==0))
		            {
		        	   result=result+"-";
		            }
		           if((checkwhobigger==0)&&(h.negsign==1)&&(this.negsign==0))
		            {
		        	   result=result+"-";
		            }
		           if((h.negsign==1)&&(this.negsign==1))
		            {
			           result=result+"-";
		            }
		           if(( checkwhobigger==1  )&&( this.negsign==0  )&&(  h.negsign==1  ))
		            {
		        	   result="";
		            }
		           if(( checkwhobigger==0  )&&( h.negsign==0  )&&(  this.negsign==1  ))
		            {
		        	   result="";
		            }
			       for(int i=(resultsize-1); i>=0; i--)
			        {
				     result=result+Character.getNumericValue(resultinreverse.charAt(i));
			        }
		         }
       		 HugeInteger output = new HugeInteger(result);
       		 return output;
       		 
       		 
       		      		 
       		 
       		 
    	  }//second scenario end: one pos,one neg
    	 HugeInteger non = new HugeInteger("404");
    	 return non;
     }//class add end
     
     public HugeInteger subtract(HugeInteger h)
     {
    	 if((h.size==1)&&(h.HugeIntArray[0]==0))
    	  {
    		 return this.add(h);
    	  }
    	 
    	   	 
    	 
    	 if((this.negsign==0)&&(h.negsign==0))
    	 {
    		//h.negsign=1;
    		String str= new String();
    		str=str+"-";
    		for(int i=0; i<h.size; i++)
    		 {
    			str=str+h.HugeIntArray[i];
    		 }
    		HugeInteger out = new HugeInteger(str);
    		return this.add(out);
    	 }
    	if((this.negsign==0)&&(h.negsign==1))
   	     {
   		   // h.negsign=0;
   		    String str= new String();
   		    for(int i=0; i<h.size; i++)
   		     {
   		    	str=str+h.HugeIntArray[i];
   		     }
   		    HugeInteger out = new HugeInteger(str);
   		    return this.add(out);
   	     }
    	if((this.negsign==1)&&(h.negsign==0))
  	     {
  		   // h.negsign=1;
  		   String str= new String();
  		   str=str+"-";
  		   for(int i=0; i<h.size; i++)
  		     {
  			   str=str+h.HugeIntArray[i];
  		     }
  		   HugeInteger out = new HugeInteger(str);
  		   return this.add(out);
  	     }
    	if((this.negsign==1)&&(h.negsign==1))
  	     {
  		    //h.negsign=0;
  		    String str= new String();
 		    for(int i=0; i<h.size; i++)
 		     {
 		    	str=str+h.HugeIntArray[i];
 		     }
 		    HugeInteger out = new HugeInteger(str);
 		    return this.add(out);
  	     }
    	 
    	
    	HugeInteger non = new HugeInteger(1);
   	 return non;

     }//Class subtract end
    
     
     
     
     
     
     
    
     
     
public HugeInteger multiply(HugeInteger h){
    	 
    	 
	HugeInteger special= new HugeInteger("0");
	 

	 
	 if((this.size==1)&&(this.HugeIntArray[0]==0))
	  {
		 return special;
	  }
	 if((h.size==1)&&(h.HugeIntArray[0]==0))
	      {
		     return special;
	      }
    	 
         HugeInteger hold = new HugeInteger("0");    //
         String addzero;
         String countzero = "";
         HugeInteger sum = new HugeInteger("0");
         HugeInteger y;
         for (int i = h.size - 1; i >= 0; i--)
           {
             for (int j = 1; j <= h.HugeIntArray[i]; j++)
              {
            	 hold = hold.add(this);
              }
             addzero = hold.toString();
             addzero += countzero;
             y = new HugeInteger(addzero);
             sum = sum.add(y);
             hold = new HugeInteger("0");
             countzero += '0';
           }
         
         if (((this.negsign == 0) && (h.negsign == 0)) || ((this.negsign == 1) && (h.negsign == 1)))
          {       	
             return sum;
          }
         else
          {    	
        		 sum.changeSign();          	 
                 return sum;
          }
       
         
     }
     
     
     
     

     public int compareTo(HugeInteger h)
     {
    	 if((this.negsign==0)&&(h.negsign==1))
    	  {
    		 return 1;
    	  }
    	 if((this.negsign==1)&&(h.negsign==0))
   	      {
   		     return -1;
   	      }
    	 if((this.negsign==0)&&(h.negsign==0)&&(this.size!=h.size))
    	  {
    		 if(this.size>h.size)
    		  {
    			 return 1;
    		  }
    		 if(this.size<h.size)
    		  {
    			 return -1;
    		  }
    	  }
    	 if((this.negsign==1)&&(h.negsign==1)&&(this.size!=h.size))
   	      {
   		     if(this.size>h.size)
   		      {
   			     return -1;
   		      }
   		     if(this.size<h.size)
   		      {
   			     return 1;
   		      }
   	      }
    	 if((this.negsign==0)&&(h.negsign==0)&&(this.size==h.size))
    	  {
    		 for(int i=0; i<h.size; i++)
			  {
				if(this.HugeIntArray[i]>h.HugeIntArray[i])
				 {
					return 1;
				 }
				if(h.HugeIntArray[i]>this.HugeIntArray[i])
				 {
					return -1;
				 }
			  }
			 return 0;
    	  }
    	 if((this.negsign==1)&&(h.negsign==1)&&(this.size==h.size))
   	      {
   		    for(int i=0; i<h.size; i++)
			  {
				if(this.HugeIntArray[i]>h.HugeIntArray[i])
				 {
					return -1;
				 }
				if(h.HugeIntArray[i]>this.HugeIntArray[i])
				 {
					return 1;
				 }
			  }
			 return 0;
   	      }
    	return 2;
     }//Class compare end
     
     
     public String toString()
     {   	 
    	 String output = new String();
         if (this.negsign == 1)
          {
        	 output=output+"-";
          }
         for (int i = 0; i < this.size; i++)
          {
             output = output+this.HugeIntArray[i];
          }
         return output;
     }
     
     public String tonosignString()
     {   	 
    	 String output = new String();
                
            for(int i = 0; i < this.size; i++)
              {
                output = output+this.HugeIntArray[i];
              }
         
         return output;
     }
     
     
     
     
     public void changeSign()
    {
         if (this.negsign == 1)
          {
             this.negsign =0;
          }
         else
          {
             this.negsign = 1;
          }
     } 
     
    
    
}