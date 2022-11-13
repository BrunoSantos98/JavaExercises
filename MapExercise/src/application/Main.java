package application;

import java.io.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //path utilizado: /code/JavaExercises-master/MapExercise/src/files/

        Scanner sc = new Scanner(System.in);
        Map<String,Integer> mapCandidate = new TreeMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.next();

        try(BufferedReader br = new BufferedReader(new FileReader(path + "votos.csv"))){
            String line = br.readLine();;
            while (line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                int vote = Integer.parseInt(fields[1]);

                if(mapCandidate.containsKey(name)){
                    mapCandidate.put(name,votesSum(vote,name,mapCandidate));
                }else {
                    mapCandidate.put(name, vote);
                }

                line = br.readLine();;
            }

            boolean succes = new File(path + "/out").mkdir();
            System.out.println("Diretorio '/out' criado com sucesso? " + succes);

            BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/out/in.txt"));
                for(String key : mapCandidate.keySet()){
                    bw.write(key + ": " + mapCandidate.get(key));
                    bw.newLine();
                }
                bw.close();


        }catch(IOException e){
            System.out.println("Erro na leitura do documento: " + e.getMessage());
        }finally {
            sc.close();
        }
    }

    public static Integer votesSum(Integer votes, String key, Map<String,Integer> candidate){
        return votes + candidate.get(key);
    }
}


/******************************* SOLUÇÃO DO CURSO **********************************

Scanner sc = new Scanner(System.in);

		Map<String, Integer> votes = new LinkedHashMap<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);

				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, count + votesSoFar);
				}
				else {
					votes.put(name, count);
				}

				line = br.readLine();
			}

			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
 */