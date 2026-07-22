class Solution {
    public int addDigits(int num) {
      int sum=0;
      if(num<10)
      return num;
      while(num>=10)
      {
        sum=0;
      while (num>0)  {
      int digit =num%10;
      sum=sum+digit;
      num=num/10;
      }
      num=sum;
      }
    return num;
    }
    
}
