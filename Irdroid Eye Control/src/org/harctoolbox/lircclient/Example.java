/*
Copyright (C) 2016, 2017 Bengt Martensson.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or (at
your option) any later version.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program. If not, see http://www.gnu.org/licenses/.
*/
package org.harctoolbox.lircclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * An example of using the API of LircClient to send and receive information from a Lirc server.
 */
public class Example {

    public static void main(String[] args) {
        try {
            LircClient lirc = new TcpLircClient("localhost", 8765, true, 5000);
            String version = lirc.getVersion();
            System.out.println(version);
           
            for (int i =0;i<1000000;i++){
            	lirc.sendIrCommand("Samsung_TV", "POWER", 0);
                System.out.println("Command successful");
                try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    		}
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Example() {
    }
}
