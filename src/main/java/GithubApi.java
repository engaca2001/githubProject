import org.kohsuke.github.*;

import java.util.List;
import java.util.Scanner;

public class GithubApi {




    public static void reposByUser(String user)
    {


        try {


            GitHub github = new GitHubBuilder().withPassword("engaca2001", "holaGithub").build();

            PagedIterable<GHRepository> repositories = github.getUser(user).listRepositories();


          for (GHRepository rep : repositories ) {
                System.out.println( rep.getName());
                commitsByRepository(rep);
            }


        }
        catch(Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public static void commitsByRepository(GHRepository repo)
    {
        PagedIterable<GHCommit> commits = repo.listCommits();

        try {
            for (GHCommit com : commits) {

                GHCommit.ShortInfo info = com.getCommitShortInfo();
                System.out.println("Commit: " + info.getAuthor().getName() + " " + info.getMessage() + " " + info.getCommitDate().toString());


            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
    public static void main(String[] args) {


          Scanner teclado = new Scanner(System.in);
          System.out.println("Introduce un usuario de Github: ");

          String user = teclado.nextLine();
          reposByUser(user);



}



}
