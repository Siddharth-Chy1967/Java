package bank;

    public class Bank{
        public String name;
        private String password;

        public void setPassword(String password){
            this.password = password;
        }
        public String getPassword(){
            System.out.println(this.password);
            return this.password;
        }
}
