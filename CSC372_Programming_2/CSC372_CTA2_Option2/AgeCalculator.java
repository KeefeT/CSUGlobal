import java.util.Date;

import java.awt.*;
import javax.swing.*;

public class AgeCalculator {
	
	@SuppressWarnings("deprecation")
	public static int calcAge(int[] bday) {
		Date bdate = new Date(bday[2] - 1900, bday[1], bday[0]);
		Date today = new Date();
		
		int age = today.getYear() - bdate.getYear();

		System.out.println(today);
		System.out.println(bdate);
		
		System.out.println(age);
		
		return age;
	}
	
	public static int[] parseAge(String s) throws Exception {

		String[] bday = s.split("-");
		int[] arr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			System.out.println(bday[i]);
			arr[i] = Integer.parseInt(bday[i]);
		}
		
		if (arr[0] > 12 || arr[0] < 1 || arr[1] > 31 || arr[1] < 1 || arr[2] < 1900 || arr[2] > 2024) {
			throw new Exception();
		}
		
		
		return arr;
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Age Calculator");
		JPanel panel = new JPanel();
		JButton button = new JButton("Calculate Age");
		JTextArea input = new JTextArea("text input area");
		JLabel label = new JLabel("Please enter age in mm-dd-yyyy format!");
		JLabel ageLabel = new JLabel("Age: ");
		
        panel.setLayout(new GridLayout(0,2,50,50));

        // Add components to the panel
		panel.add(input);
		panel.add(label);
		panel.add(button);
		panel.add(ageLabel);
		
		button.addActionListener(event -> {
			
			String in = input.getText();
			
			try {
				
				int[] bday = parseAge(in);
				int age = calcAge(bday);
				ageLabel.setText("Age: " + age);
				
			} catch (Exception e) {
				input.setText("Error, invalid format");
				ageLabel.setText("Age: ");
			}
			
			
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
