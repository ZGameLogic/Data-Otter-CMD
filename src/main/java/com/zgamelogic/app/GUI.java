package com.zgamelogic.app;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;


public class GUI {
    private final DataOtterModel model;

    public GUI(DataOtterModel model) {
        this.model = model;
        new Thread(this::mainLoop, "GUI-MainLoop").start();
    }

    private void mainLoop() {
        try {
            Screen screen = new TerminalScreen(new DefaultTerminalFactory().createTerminal());
            screen.startScreen();
            screen.setCursorPosition(null);
            TextGraphics g = screen.newTextGraphics();

            while (true) {
//            screen.clear();

                // Title
                g.setForegroundColor(TextColor.ANSI.GREEN);
                g.putString(2, 1, "My Dashboard");

                // Draw a bar
                int barWidth = 30;
                int value = (int) (Math.random() * barWidth);

                g.setForegroundColor(TextColor.ANSI.CYAN);
                g.putString(2, 3, "[" + "#".repeat(value) + " ".repeat(barWidth - value) + "]");

                // Draw a simple sparkline
                g.setForegroundColor(TextColor.ANSI.YELLOW);
                for (int i = 0; i < 40; i++) {
                    int h = (int) (Math.random() * 5);
                    g.putString(2 + i, 6 - h, "▇"); // fancy block
                }

                screen.refresh();

                Thread.sleep(200);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
