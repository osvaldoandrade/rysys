package br.com.codecompany.rysys.jmx.client.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
 
public class UIManagerList {
 
    public static void main(String[] args) {
        UIDefaults defaults = UIManager.getDefaults();
        System.out.println(defaults.size()+ " properties deffined !");
        String[ ] colName = {"Key", "Value"};
        String[ ][ ] rowData = new String[ defaults.size() ][ 2 ];
        
        Comparator<Object> comparator = 
        	new Comparator<Object> () {
				public int compare(Object o1, Object o2) {
					return String.valueOf(o1).compareTo(String.valueOf(o2));
				}        	
        };
        
        List<Object> list = new ArrayList<Object>();

        Enumeration<Object> enumeration = defaults.keys();
        while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			list.add(object);
		}

        
        Collections.sort(list, comparator);
        
        for(int i = 0; i < list.size(); i++){
            rowData[ i ] [ 0 ] = String.valueOf(list.get(i));
            rowData[ i ] [ 1 ] = String.valueOf(defaults.get(list.get(i)));
        }
        
        JFrame f = new JFrame("UIManager properties default values");
        JTable t = new JTable(rowData, colName);
        f.setContentPane(new JScrollPane(t));
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}