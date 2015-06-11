all: class
	
class: compute engine/*.java client/*.java
	echo "Computing classes"
	javac -cp ./compute.jar:./gson.jar engine/ComputeEngine.java
	javac -cp ./compute.jar:./gson.jar client/*.java 
	# scp compute.jar ra103659@ssh.students.ic.unicamp.br:~/public_html/mc833
	# scp client/Pi.class ra103659@ssh.students.ic.unicamp.br:~/public_html/mc833

compute: compute.jar compute/Compute.java compute/Request.java models
	echo "Computing jar"
	javac compute/*.java
	jar cvf compute.jar compute/*.class model/*.class

models:
	echo "Computing Models"
	javac -cp ./gson.jar model/*.java

run-server:
	java -cp /Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3:/Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3/compute.jar:/Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3:/Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3/gson.jar -Djava.rmi.server.codebase=http://www.students.ic.unicamp.br/~ra103659/mc833/compute.jar -Djava.security.policy=server.policy engine.ComputeEngine

run-client:
	java -cp /Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3:/Users/nickmm/Dropbox/Unicamp/mc833/mc833-p3/compute.jar -Djava.security.policy=client.policy client.ComputeClient 127.0.0.1 45

clean:
	find . -name *.class -delete