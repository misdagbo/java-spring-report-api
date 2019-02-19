/**
 * 
 */
package com.w4.report.contracts;


import javax.xml.bind.annotation.XmlRootElement;
import com.w4.report.infrastructures.RequestBase;
import com.w4.report.models.TaskItem;

/**
 * @author frederic
 *
 */
@XmlRootElement
public class TaskRequest extends RequestBase {
	private TaskItem taskItem;
	private boolean nextStep;
	private int alarm;
	private int delai;
	
	/**
	 * 
	 */
	public TaskRequest() {
		super();
		// TODO Auto-generated constructor stub
		taskItem = new TaskItem();
	}

	/**
	 * @return the taskItem
	 */
	public TaskItem getTaskItem() {
		return taskItem;
	}

	/**
	 * @param taskItem
	 *            the taskItem to set
	 */
	public void setTaskItem(TaskItem taskItem) {
		this.taskItem = taskItem;
	}

	/**
	 * @return the nextStep
	 */
	public boolean isNextStep() {
		return nextStep;
	}

	/**
	 * @param nextStep
	 *            the nextStep to set
	 */
	public void setNextStep(boolean nextStep) {
		this.nextStep = nextStep;
	}

	/**
	 * @return the alarm
	 */
	public int getAlarm() {
		return alarm;
	}

	/**
	 * @param alarm
	 *            the alarm to set
	 */
	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
}
