package com.company;

class Subcriber {
    private String name;
    private long g;
    private long p;
    private long closedKey;
    private long openKey;
    private long opositeOpenKey;
    private long secretKey;

   private Math math=new Math();

   Subcriber(String name){
       this.name=name;
   }

    private void generateGandP(){
        this.p=math.getNumber()+1;
        this.g=math.primitiveRoot(math.numberFactorization());
        System.out.println("p="+this.p+" g="+this.g);
    }

  private void sendGandP (Subcriber sub){
        sub.setPandG(this.g,this.p);
        System.out.println(this.getName()+" have send g="+this.g+" p="+this.p+" to "+sub.getName());
    }

  private   void setPandG(long g, long p){
        this.g=g;
        this.p=p;
    }
   private void generateClosedKey(){
       this.closedKey=math.randomNatural();
        System.out.println(this.getName()+" have generated ClosedKey="+this.closedKey);
    }
    private void computeOpenKey(){
        this.openKey=(math.powMod(g,closedKey,this.p));
        System.out.println(this.getName()+" have computed OpenKey="+this.openKey);
    }
   private void setOpositeOpenKey(long opositeOpenKey){
        this.opositeOpenKey=opositeOpenKey;
    }
   private void sendOpenKey(Subcriber sub){
        sub.setOpositeOpenKey(this.openKey);
        System.out.println(this.getName()+" have sended OK="+this.openKey+" and "+sub.getName()+" did the same, his OK="+sub.openKey);
    }

   private void computeSecretKey(){

        this.secretKey=(math.powMod(opositeOpenKey,closedKey,this.p));
        System.out.println(this.getName()+" have computed SecretKey="+this.getSecretKey());
    }
    private long getSecretKey(){
       return this.secretKey;
    }

    String exchangeKeysProcess(Subcriber sub){

        this.generateClosedKey();
        sub.generateClosedKey();
        this.generateGandP();
        this.sendGandP(sub);
        this.computeOpenKey();
        sub.computeOpenKey();
        this.sendOpenKey(sub);
        sub.sendOpenKey(this);
        this.computeSecretKey();
        sub.computeSecretKey();
        if(this.getSecretKey()==sub.getSecretKey()){
            return "the same";
        }
        else{
            return "different";
        }
    }
    String getName(){
       return this.name;
    }


}
