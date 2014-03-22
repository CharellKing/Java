package peilingli.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DateFrame {

	private JFrame frame;
	private JTextField textFieldYear;
	private JTextField textFieldMonth;
	private JTextField textFieldDay;
	private JLabel resultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateFrame window = new DateFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DateFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldYear = new JTextField();
		textFieldYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}
			}
		});
		textFieldYear.setText("2014");
		textFieldYear.setBounds(29, 65, 62, 19);
		frame.getContentPane().add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("年");
		lblNewLabel.setToolTipText("范围[1920, 2050]");
		lblNewLabel.setBounds(120, 67, 19, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldMonth = new JTextField();
		textFieldMonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}
			}
		});
		textFieldMonth.setText("3");
		textFieldMonth.setColumns(10);
		textFieldMonth.setBounds(168, 65, 62, 19);
		frame.getContentPane().add(textFieldMonth);
		
		textFieldDay = new JTextField();
		textFieldDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}
			}
		});
		textFieldDay.setText("22");
		textFieldDay.setColumns(10);
		textFieldDay.setBounds(307, 65, 62, 19);
		frame.getContentPane().add(textFieldDay);
		
		JLabel label = new JLabel("月");
		label.setBounds(259, 67, 19, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("日");
		label_1.setBounds(398, 67, 19, 15);
		frame.getContentPane().add(label_1);
		
		resultLabel = new JLabel("明天的日期是2014年3月23日");
		resultLabel.setBounds(117, 156, 263, 15);
		frame.getContentPane().add(resultLabel);
	}
	
	private void getResult() {
		if (textFieldYear.getText().isEmpty() || 
			textFieldMonth.getText().isEmpty() ||
			textFieldDay.getText().isEmpty()) {
			resultLabel.setText("");
		} else {
			Date date = new Date(Integer.parseInt(textFieldYear.getText()), 
					Integer.parseInt(textFieldMonth.getText()), Integer.parseInt(textFieldDay.getText()));
			String ret = date.getResult();
			resultLabel.setText(ret);
		}
	}
}
