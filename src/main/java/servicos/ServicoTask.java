
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import respositorios.TaskRespositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoTask {
	
	 private TaskRespositorio taskRepositorio;

	 
	 @Autowired
	 public ServicoTask(TaskRespositorio taskRepositorio) {
	     this.taskRepositorio = taskRepositorio;
	 }
	 
	 public List<Task> getAllTasks() {
	     return taskRepositorio.findAll();
	 }
	 
	 public Optional<Task> getTaskById(Long taskId) {
	     return taskRepositorio.findById(taskId);
	 }
	 
	 public Task createTask(Task task) {	 
	     return taskRepositorio.save(task);
	 }
	 
	 public Task updateTask(Long id, Task updatedTask) {
		 if (taskRepositorio.existsById(id)) {
	        updatedTask.setId(id);
	        return taskRepositorio.save(updatedTask);
	        } else {
	            return null; 
	        }
	    }
	 
	    public void deleteTask(Long taskId) {
	    	taskRepositorio.deleteById(taskId);
	    }

}
