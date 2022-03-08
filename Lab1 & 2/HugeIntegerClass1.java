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
    		 throw new IllegalArgumentException("Invalid Inputs");
    	  }
    	// ********************
    	 if(sign==negative)//#1
    	  {
    		 int ifzero=0;
    		 for(int i=1; i<=(length-1); i++)
    		   {
    			 if(Character.isDigit(val.charAt(i))==false)
    			  {
    				 throw new IllegalArgumentException("Invalid Inputs");
    			  }
    			 if(Character.getNumericValue(val.charAt(i))==0)
    			  {
    				 ifzero=1;
    			  }
    			 if(ifzero==1)
    			  {
    				 throw new IllegalArgumentException("Invalid Inputs");
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
    				 throw new IllegalArgumentException("Invalid Inputs");
    			  }
    			 digit=Character.getNumericValue(val.charAt(i));
    			 arr[i-1]=digit;
      	       }
    		 this.HugeIntArray=arr;
    	  }
    	 if(sign!=negative)//#2
    	  {
    		 this.size=length;
    		 int arr[]= new int[length];//same array as HugeIntArray
    		 this.negsign=0;//mark the negtive sign
    		 for(int i=0; i<=(length-1); i++)
      	       {
    			 if(Character.isDigit(val.charAt(i))==false)
   			      {
   				     throw new IllegalArgumentException("Invalid Inputs");
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
    		 throw new IllegalArgumentException("Invalid Inputs");
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
//    		 int hold;
 //   		 int nextbit=0;
    		 int currentbit;
 //   		 String tostr;//change hold to string format
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
    						if(this.HugeIntArray[j]==0)//check if the next bit of the above one is 0
    						 {
    						  while((this.HugeIntArray[j]==0)&&(j>=1))
    						    {
    							 this.HugeIntArray[j]=9;
    							 j--;
    						    }
    						  this.HugeIntArray[j]=this.HugeIntArray[j]-1;
    						 }
    						if(this.HugeIntArray[j]!=0)//the next bit of the above one is not 0
    						 {
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
    						if(h.HugeIntArray[j]==0)//check if the next bit of the above one is 0
   						     {
   						       while((h.HugeIntArray[j]==0)&&(j>=1))
   						        {
   							     h.HugeIntArray[j]=9;
   							     j--;
   						        }
   						       h.HugeIntArray[j]=h.HugeIntArray[j]-1;
   						     }
   						    if(h.HugeIntArray[j]!=0)//the next bit of the above one is not 0
   						     {
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
    			int checkwhobigger=0;
    			for(int i=0; i<h.size; i++)//check which is bigger
    			  {
    				if(this.HugeIntArray[i]>h.HugeIntArray[i])
    				 {
    					checkwhobigger=1;
    					break;
    				 }
    			  }
    			if(checkwhobigger==1)
    			 {
    				for(int i=(h.size-1); i>=0; i--)//the part that both array have same length
  				      {
  					    counter++;
  					    if(this.HugeIntArray[i]>=h.HugeIntArray[i])//if the bit I am currently operating:above>below
  					     {
  						   currentbit=this.HugeIntArray[i]-h.HugeIntArray[i];
  						 resultinreverse=resultinreverse+currentbit;
  					     }
  					    if(this.HugeIntArray[i]<h.HugeIntArray[i])//if the bit I am currently operating:above<below
  					     {
  					    	int j=this.size-counter-1;
  					    	if(j!=-1)
  					    	{
    						if(this.HugeIntArray[j]==0)//check if the next bit of the above one is 0
    						 {
    						  while((this.HugeIntArray[j]==0)&&(j>=1))
    						    {
    							 this.HugeIntArray[j]=9;
    							 j--;
    						    }
    						  this.HugeIntArray[j]=this.HugeIntArray[j]-1;
    						 }
    						if(this.HugeIntArray[j]!=0)//the next bit of the above one is not 0
    						 {
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
  						resultinreverse=resultinreverse+currentbit;
  					 }
  					if(this.HugeIntArray[i]>h.HugeIntArray[i])//if the bit I am currently operating:above<below
  					 {
  						int j=h.size-counter-1;
  						if(j!=1)
  						{
						if(h.HugeIntArray[j]==0)//check if the next bit of the above one is 0
						 {
						   while((h.HugeIntArray[j]==0)&&(j>=1))
						     {
							  h.HugeIntArray[j]=9;
							  j--;
						     }
						   h.HugeIntArray[j]=h.HugeIntArray[j]-1;
						 }
						if(h.HugeIntArray[j]!=0)//the next bit of the above one is not 0
						 {
						   h.HugeIntArray[j]=h.HugeIntArray[j]-1;
						 }
						currentbit=10-this.HugeIntArray[i]+h.HugeIntArray[i];
						resultinreverse=resultinreverse+currentbit;
  						}
  					 }

  				  }
    			 }
    		  }//#3 end
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
       		    	int checkwhobigger=0;
        			for(int i=0; i<h.size; i++)//check which is bigger
        			  {
        				if(this.HugeIntArray[i]>h.HugeIntArray[i])
        				 {
        					checkwhobigger=1;
        					break;
        				 }
        			  }
		           if(((checkwhobigger==1)&&(this.negsign==1)&&(h.negsign==0))||((checkwhobigger==0)&&(h.negsign==1)&&(this.negsign==0))||((h.negsign==1)&&(this.negsign==1)))
		            {
			         result=result+"-";
		            }
			       for(int i=(resultsize-1); i>=0; i--)
			        {
				     result=result+Character.getNumericValue(resultinreverse.charAt(i));
			        }
		         }
       		 HugeInteger output = new HugeInteger(result);
       		 return output;
    	  }//second scenario end: one pos,one neg
    	 HugeInteger non = new HugeInteger(1);
    	 return non;
     }//class add end
     
     public HugeInteger subtract(HugeInteger h)
     {
    	if((this.negsign==0)&&(h.negsign==0))
    	 {
    		h.negsign=1;
    		return this.add(h);
    	 }
    	if((this.negsign==0)&&(h.negsign==1))
   	     {
   		    h.negsign=0;
   		    return this.add(h);
   	     }
    	if((this.negsign==1)&&(h.negsign==0))
  	     {
  		    h.negsign=1;
  		    return this.add(h);
  	     }
    	if((this.negsign==1)&&(h.negsign==1))
  	     {
  		    h.negsign=0;
  		    return this.add(h);
  	     }
    	HugeInteger non = new HugeInteger(1);
   	 return non;

     }//Class subtract end
     
     public HugeInteger multiply(HugeInteger h)
     {
    	 int countzero=-1;
    	 int hold;
    	 int currentbit;
    	 int nextbit=0;
    	 String tostr;//change hold to string format
    	 String resultinreverse = new String();
    	 HugeInteger sum= new HugeInteger("");//carry on the value of each calculation
    	 
    	 int resultsize;                  //for convert
		 String result = new String();    //for convert
    	 
    	 if(this.size>=h.size)//#1 scenario
    	  {
    		 for(int i=(h.size-1); i>=0; i--)//#1 for loop
    		  {
    			 if(h.HugeIntArray[i]!=0)
    			  {
    				 countzero++;
    			  }
    			 if(h.HugeIntArray[i]==0)
   			      {
   				     countzero++;
   				     continue;
   			      }
    			 for(int j=(this.size-1); j>=0; j--)//#2 for loop
    			  {
    				resultinreverse=resultinreverse+(10*countzero);
    				hold=h.HugeIntArray[i]*this.HugeIntArray[j]+nextbit;
    				
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
   				        currentbit=Character.getNumericValue(tostr.charAt(1));			
   				        nextbit=0;
   				        resultinreverse=resultinreverse+currentbit;
    				 }			   				
    			  }//#2 loop end
    			 
    			//Below: reverse the result into correct order
        		 resultsize=resultinreverse.length(); 		 
        	     for(int k=(resultsize-1); k>=0; k--)
        		   {
        			result=result+Character.getNumericValue(resultinreverse.charAt(k));
        		   }
        	    //Below: add hold to sum
        	     HugeInteger carry= new HugeInteger(result);
        	     sum=sum.add(carry);   			 
    		  }//#1 loop end
    	  }//#1 scenario end
    	 
    	if(h.size>=this.size)//#2 scenario
   	    {
   		 for(int i=(this.size-1); i>=0; i--)//#1 for loop
   		  {
   			 if(this.HugeIntArray[i]!=0)
   			  {
   				 countzero++;
   			  }
   			 if(this.HugeIntArray[i]==0)
  			  {
  				 countzero++;
  				 continue;
  			  }
   			 for(int j=(h.size-1); j>=0; j--)//#2 for loop
   			  {
   				resultinreverse=resultinreverse+(10*countzero);
   				hold=h.HugeIntArray[i]*this.HugeIntArray[j]+nextbit;
   				
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
  				     currentbit=Character.getNumericValue(tostr.charAt(1));			
  				     nextbit=0;
  				     resultinreverse=resultinreverse+currentbit;
   				 }			   				
   			  }//#2 loop end
   			 
   			//Below: reverse the result into correct order
       		 resultsize=resultinreverse.length(); 		 
       	     for(int m=(resultsize-1); m>=0; m--)
       		   {
       			result=result+Character.getNumericValue(resultinreverse.charAt(m));
       		   }
       	    //Below: add hold to sum
       	     HugeInteger carry= new HugeInteger(result);
       	     sum=sum.add(carry);   			 
   		  }//#1 loop end
   	   }//#2 scenario end
    	 
    	 
    	 //add sign to sum/AND RETURN FINAL OUTPUT
    		 if((this.negsign==1)||(h.negsign==1))
    		  {
    			 String addsigntosum= new String();
    			 addsigntosum=addsigntosum+"-"+sum.toString();
    			 HugeInteger output = new HugeInteger(addsigntosum);
    			 return output;
    		  }
    		 return sum;
    		    	 
     }//Class multiply end
     
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
             output += "-";
          }
         for (int i = 0; i < this.size; i++)
          {
             output = output+this.HugeIntArray[i];
          }
         return output;
     }
     
             
     
     
}//Whole class end