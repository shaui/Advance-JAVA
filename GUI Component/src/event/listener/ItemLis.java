package event.listener;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*不適合單獨寫出來，因為可能會用到EventSource以外的Component*/
public class ItemLis implements ItemListener
{
	Font f;
	int style;
	public ItemLis(Font f,int style)
	{
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			
		}
		else
		{
		
		}
	
	}
}
