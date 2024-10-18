package Solutions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Digital_Clock extends JFrame
{
    private JLabel timeLabel;  // Label to display the current time
    private JLabel dateLabel;  // Label to display the current date

    public Digital_Clock()
    {
        // Set the title of the frame
        setTitle("Digital Clock");

        // Set the dimensions of the frame
        setSize(500, 200);

        // Specify the operation that will happen by default when the user initiates a "close" on this frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Prevent the user from resizing the window
        setResizable(false);

        // Create a panel to hold the time and date labels
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
        panel.setLayout(new BorderLayout()); // Use BorderLayout for layout management

        // Create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60)); // Set font size and style
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        timeLabel.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        timeLabel.setForeground(Color.WHITE); // Set text color to white

        // Create a label to display the date
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size and style for the date
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        dateLabel.setVerticalAlignment(SwingConstants.CENTER); // Center the text vertically
        dateLabel.setForeground(Color.WHITE); // Set text color to white

        // Add the time and date labels to the panel
        panel.add(timeLabel, BorderLayout.CENTER); // Add timeLabel to the center of the panel
        panel.add(dateLabel, BorderLayout.SOUTH); // Add dateLabel to the south (bottom) of the panel

        // Set the panel's background color to black
        panel.setBackground(Color.BLACK);

        // Add the panel to the frame
        add(panel);

        // Use a Timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateTimeAndDate(); // Call the method to update time and date
            }
        });
        timer.start(); // Start the timer
    }

    private void updateTimeAndDate()
    {
        // Get the current time using Calendar
        Calendar calendar = Calendar.getInstance();

        // Create a formatter for the time in HH:mm:ss format
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormatter.format(calendar.getTime()); // Format the current time

        // Create a formatter for the date in EEE, MMM dd, yyyy format
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
        String date = dateFormatter.format(calendar.getTime()); // Format the current date

        // Update the time and date labels with the formatted values
        timeLabel.setText(time);
        dateLabel.setText(date);
    }

    // Main method to run the Digital Clock application
    public static void main(String[] args)
    {
        Digital_Clock clock = new Digital_Clock(); // Create an instance of the clock
        clock.setVisible(true); // Make the clock visible
    }
}
