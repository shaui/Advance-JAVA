package event.listener;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*���A�X��W�g�X�ӡA�]���i��|�Ψ�EventSource�H�~��Component*/
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
