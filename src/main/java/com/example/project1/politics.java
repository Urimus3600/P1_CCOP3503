//COP 3503c Project Created by Austin Mathew
package com.example.project1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class politics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //initial read in to check for end case and prevent garbage
        int nCandidates = input.nextInt();
        int nSupporters = input.nextInt();

        //checks for end condition for program
        while (nCandidates != 0) {
            // Declare other variables here.
            //<candidate, list of supporter names>
            HashMap<String, LinkedList<String>> Candidate = new HashMap<>();
            //keep candidate names in order
            LinkedList<String> Candidates = new LinkedList<>();
            String supportName, candidateName;

            // Read input for one case.
            // Process information.

            //reads in all known candidates
            for(int i=0; i<nCandidates; i++){
                candidateName = input.next();
                Candidates.add(candidateName);
                Candidate.put(candidateName, new LinkedList<>());
            }

            //reads in all supports and enters them into their candidate's list
            for(int i=0; i<nSupporters; i++){
                supportName = input.next();
                candidateName = input.next();
                //either way the linked list must be accessed
                LinkedList<String> cur;

                if(Candidate.containsKey(candidateName)){
                   cur = Candidate.get(candidateName);
                   cur.add(supportName);
                }
                else{
                    Candidates.add(candidateName);
                    cur = new LinkedList<>();
                    cur.add(supportName);
                    Candidate.put(candidateName, cur);
                    nCandidates++;
                }
            }

            // Output answer for one case.
            for(int i=0; i<nCandidates; i++){
                //for Linked list interaction
                LinkedList<String> cur;
                //find candidate based on known candidates list
                cur = Candidate.get(Candidates.get(i));
                //read in loop number
                int votes = cur.size();
                for(int j=0; j<votes; j++){
                    System.out.println(cur.get(j));
                }
            }
            //read in next case variables
            nCandidates = input.nextInt();
            nSupporters = input.nextInt();
        }
    }
}
