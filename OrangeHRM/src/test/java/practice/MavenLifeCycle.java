package practice;


/*Maven has clean life cycle and build life cycle
 * it also has site life cycle
 *    Clean life cycle -1.. Pre-Clean
 *    					2.. Clean
 *    					3.. Post-Clean	
 * All clean's goal is to delete any previous build directories and re-download them.
 * 	  
 * 	  Build life cycle - There are 9 phases in total.
 * 		if we call the latest phase it will include all the phases. 
 * 					Phase 1 - Validate : checks whether the project has all the info it needs.
 * 					Phase 2 - Initialize : it starts  setting up the properties for the build
 * 					Phase 3 - Compile : it gets all the source code and translates it.
 * 					phase 4 - Test Compile : it compiles the source code for the test.
 * 					phase 5 - Test : it runs the profiles that's given. If no profile given then it will run all @Test from the project.
 * 					phase 6 - Package : Once all the test case pass/success then it will create a package. 
 * 					phase 7 - Verify : it will run the last check-up for the package to see its met the criteria.
 * 					phase 8 - Install : this is where it will create a package into the local repositories.
 * 					phase 9 - Deploy : It will now put into the remote repository.  
 * 
 * */


public class MavenLifeCycle {

}
