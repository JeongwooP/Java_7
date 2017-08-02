package java7net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UrlTest2 extends JFrame {
	JPanel panel;
	JTextField txt1, txt2, txt3, txt4;
	JButton btnSearch, btnShowMap;

	public UrlTest2() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);

		// 1행
		JLabel label = new JLabel("정보 입력:");
		label.setBounds(30, 15, 90, 15);
		panel.add(label);
		txt1 = new JTextField();
		txt1.setBounds(130, 10, 200, 20);
		panel.add(txt1);
		btnSearch = new JButton("검색");
		btnSearch.setBounds(350, 10, 100, 20);
		panel.add(btnSearch);

		// 2행
		JLabel label2 = new JLabel("주 소:");
		label2.setBounds(30, 45, 90, 15);
		panel.add(label2);
		txt2 = new JTextField();
		txt2.setBounds(130, 40, 200, 20);
		txt2.setEditable(false);
		panel.add(txt2);
		btnShowMap = new JButton("지도보기");
		btnShowMap.setBounds(350, 40, 100, 20);
		panel.add(btnShowMap);

		// 3행
		JLabel label3 = new JLabel("위 도:");
		label3.setBounds(30, 75, 90, 15);
		panel.add(label3);
		txt3 = new JTextField();
		txt3.setBounds(130, 70, 200, 20);
		txt3.setEditable(false);
		panel.add(txt3);

		// 4행
		JLabel label4 = new JLabel("경 도:");
		label4.setBounds(30, 105, 90, 15);
		panel.add(label4);
		txt4 = new JTextField();
		txt4.setBounds(130, 100, 200, 20);
		txt4.setEditable(false);
		panel.add(txt4);

		setTitle("URL 연습");
		setBounds(200, 500, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트 처리
		btnSearch.addActionListener(e -> {
			if (txt1.getText().equals(""))
				return;

			String search = txt1.getText();
			String url1 = "https://maps.googleapis.com/maps/api/geocode/xml?address=";
			String url2 = "&language=ko";
			String searchUrl = url1 + search + url2;
			// System.out.println(searchUrl);

			try {
				URL url = new URL(searchUrl);
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String line = "";
				String address = "";
				String lat = "";
				String lng = "";
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
					if (line.contains("<formatted_address>")) {
						// 주소 얻기
						// System.out.println("line---" + line);
						line = line.replace("<formatted_address>", "");
						line = line.replace("</formatted_address>", "");
						address = line.trim();
						// System.out.println(address);
					} else if (line.contains("<lat>")) {
						line = line.replace("<lat>", "");
						line = line.replace("</lat>", "");
						lat = line.trim();
					} else if (line.contains("<lng>")) {
						line = line.replace("<lng>", "");
						line = line.replace("</lng>", "");
						lng = line.trim();
						break;
					}
				} // while 끝
				txt2.setText(address);
				txt3.setText(lat);
				txt4.setText(lng);
			} catch (Exception e2) {
				System.out.println("search err: " + e2);
			}
		});

		btnShowMap.addActionListener(e -> {
			// 지도 보기(Brwoser 사용)
			String mapurl = "http://www.google.co.kr/maps/@" + txt3.getText() + "," + txt4.getText() + ",16z";

			// System.out.println(mapurl);

			ProcessBuilder pb = new ProcessBuilder("C:/Program Files/Internet Explorer/iexplore.exe", mapurl);
			try {
				pb.start();
			} catch (Exception e2) {
				System.out.println("explore err:" + e2);
			}
		});
	}

	public static void main(String[] args) {
		new UrlTest2();
	}

}
