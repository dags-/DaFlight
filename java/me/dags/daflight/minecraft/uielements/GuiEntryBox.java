/*
 * Copyright (c) 2014, dags_ <dags@dags.me>
 *
 *  Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby
 *  granted, provided that the above copyright notice and this permission notice appear in all copies.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING
 *  ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL,
 *  DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 *  WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE
 *  USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package me.dags.daflight.minecraft.uielements;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class GuiEntryBox extends GuiTextField
{

    private boolean isActive;
    private int x;
    private int y;
    private int width;
    private int height;

    public GuiEntryBox(FontRenderer fr, int x, int y, int width, int height)
    {
        super(0, fr, x, y, width, height);
        this.setFocused(false);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public void name(String s)
    {
        this.setText(s);
    }

    public void draw()
    {
        this.drawTextBox();
    }

    public void setActive()
    {
        this.isActive = true;
        setText(EnumChatFormatting.RED.toString() + this.getText());
        this.setFocused(false);
    }

    public void unsetActive()
    {
        this.isActive = false;
        setText(this.getText().replaceFirst(EnumChatFormatting.RED.toString(), ""));
        this.setFocused(false);
    }

    public void entry(char keyChar, int id)
    {
        if (id == Keyboard.KEY_BACK && this.getText().length() <= 2)
        {
            return;
        }
        super.textboxKeyTyped(keyChar, id);
    }

    public String getString()
    {
        return getText().replaceFirst(EnumChatFormatting.RED.toString(), "");
    }

    public boolean click(int mouseX, int mouseY)
    {
        return ((mouseX > this.x) && (mouseX < this.x + width)) && ((mouseY > this.y) && (mouseY < this.x + height));
    }

}