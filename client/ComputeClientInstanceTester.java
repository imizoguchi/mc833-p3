/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import compute.*;
import model.Movie;
import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ComputeClientInstanceTester extends ComputeClientInstance {

	List<List<Response>> mResponses;

	void executeClient() throws RemoteException {

		mResponses = new ArrayList<List<Response>>();
		
		for(int i = 0; i < 7; i++) {
			mResponses.add(new ArrayList<Response>());
		}

		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = findMoviesWithTitleAndReleaseDate();
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(0).add(res);
		}

		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = findMoviesWithTitleAndReleaseDateByGenre("Comedy");
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(1).add(res);
		}

		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = findMovieSynopsis(771325854);
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(2).add(res);
		}

		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = findMovie(771325854);
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(3).add(res);
		}
		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = findAllMovies();
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(4).add(res);
		}
		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = rentMovie(771325854);
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(5).add(res);
		}
		for(int i = 0; i < 30; i++) {
			long t_start = System.nanoTime();
			Response res = movieInStock(771325854);
			long t_end = System.nanoTime();
			res.totalTime = t_end-t_start;
			mResponses.get(6).add(res);
		}

		generateTable();

		return;
	}

	public void generateTable() {
		System.out.println(",Operação 1,,,Operação 2,,,Operação 3,,,Operação 4,,,Operação 5,,,Operação 6,,,Operação 7,,,");
		System.out.println("n,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,Tconsulta,Ttotal,Tcomunicação,");
		for(int i = 0; i < 30; i++) {
			String line = ""+(i+1)+",";
			for(List<Response> res : mResponses) {
				long t1,t2,t3,tm;
				t1 = res.get(i).processingTime;
				double tf1 = t1/1000000000.0;
				t2 = res.get(i).totalTime;
				double tf2 = t2/1000000000.0;
				
				double tf3 = tf2-tf1;
				line = line+tf1+","+tf2+","+tf3+",";
			}

			System.out.println(line);
		}
	}
}
