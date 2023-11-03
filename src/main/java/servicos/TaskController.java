package servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	 private ServicoTask servicoTask ;
	 
	 @Autowired
	  public TaskController(ServicoTask servicoTask) {
	     this.servicoTask = servicoTask;
	  }
	 
	 @GetMapping
	  public List<Task> getAllTasks() {
	     return servicoTask.getAllTasks();
	  }
	 
	 @GetMapping("/{taskId}")
	  public Task getTaskById(@PathVariable Long taskId) {
	     return servicoTask.getTaskById(taskId).orElse(null);
	  }
	 
	 @PostMapping
	  public Task createTask(@RequestBody Task task) {
	     return servicoTask.createTask(task);
	  }
	 
	 @PutMapping("/{taskId}")
	  public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
	     return servicoTask.updateTask(taskId, updatedTask);
	  }
	 
	 @DeleteMapping("/{taskId}")
	  public void deleteTask(@PathVariable Long taskId) {
		 servicoTask.deleteTask(taskId);
	  }
}

