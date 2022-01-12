package T2;

import T1.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class TeamUtils extends Exception{

    public static class BasicTeam {

        protected  int points=0;
        private String name;

        public BasicTeam(String name, int points){
            this.name = name;
            this.points = points;
        }

        public String getName(){
            return this.name;
        }

        public int getPoints(){
            return this.points;
        }

    }

    public static class Team extends BasicTeam {

        private int nrJogos=0;

        public Team(String name){
            super(name,0);

        }
        public void addGame(int points){
            this.points += points;
            nrJogos += 1;
        }

        public int playedGames(){
            return nrJogos;
        }

        public boolean equals(Object o) { //'??????''''''''??'''''''''???????????????????? Comparação de nomes
            if (o instanceof Team) {
                Team other = (Team) o;
                return  this.nrJogos == other.nrJogos && this.points == other.points;
            }
            return false;
        }

        public int hashCode(){
            return Objects.hash(playedGames());
        }

        public String toString(){
            return playedGames() +"";
        }
    }

    public static class Game  {

        public final BasicTeam visitor;
        public final BasicTeam visited;
        private  String Description;


        public Game(String gameDescription) {
            Description = gameDescription;
            String v1,v2;
            int p1=0,p2=0;
            int index1 = Description.indexOf("-",0);
            v1 = Description.substring(0,index1).trim();
            v2 = Description.substring(index1,Description.length()-2).trim();


            final char result = getResult();

            if (result == 'x') p1=p2 =1;
            else if (result == '1') p1=3;
            else p2=3;

            visitor = new BasicTeam(v2,p2);
            visited = new BasicTeam(v1,p1);

        }

        public char getResult() {
            return Description.charAt(Description.length()-1);
        }

        public String toString(){
            return visited + " " + visitor;
        }
    }

    void loadFrom (Map<String, Team> teams, BufferedReader games) throws Exception {
       //key nome das equipas
       //teams -> contentor
        // ler linhas, cada linha  instanciar um jogo, verificar em cada jogo(get) se a key existe em teams caso exista
        //adicionar um jogo, caso nao exista

        String buffer;

        while ((buffer = games.readLine()) != null){
            Game jogo = new Game(buffer);
            Team T = teams.get(jogo.visitor.name);

            if(T == null){
                T = new Team(jogo.visitor.name);
                T.addGame(jogo.getResult());
            } else teams.put();

            Team S = teams.get(jogo.visited.name);

        }





        /*
        String buffer;
        try{
            buffer = games.readLine();
        }catch(IOException e) throw new Exception();
        Team novo;
        teams.put(buffer,novo);

         */
    }

}
