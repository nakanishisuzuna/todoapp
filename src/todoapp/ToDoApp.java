package todoapp;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    static ArrayList<ToDo> todos = new ArrayList<>();
    static int idCounter = 1;
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. TODOの追加");
            System.out.println("2. TODOの削除");
            System.out.println("3. TODOの編集");
            System.out.println("4. TODOの一覧を表示");
            System.out.println("5. 終了");
            System.out.print("操作を選択してください: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addTodo();
                    break;
                case 2:
                    deleteTodo();
                    break;
                case 3:
                    editTodo();
                    break;
                case 4:
                    displayTodos();
                    break;
                case 5:
                    System.out.println("アプリケーションを終了します。");
                    return;
                default:
                    System.out.println("無効な選択です。もう一度選択してください。");
            }
        }
    }
    
    static void addTodo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("TODOのタイトルを入力してください: ");
        String title = scanner.nextLine();
        
        System.out.println("ステータスを選択してください:");
        System.out.println("1. 未着手");
        System.out.println("2. 進行中");
        System.out.println("3. 完了");
        System.out.print("ステータス番号を入力してください: ");
        int statusChoice = scanner.nextInt();
        String status;
        switch (statusChoice) {
            case 1:
                status = "未着手";
                break;
            case 2:
                status = "進行中";
                break;
            case 3:
                status = "完了";
                break;
            default:
                System.out.println("無効なステータス番号です。未着手として登録します。");
                status = "未着手";
        }
        
        ToDo todo = new ToDo();
        todo.setId(idCounter++);
        todo.setTitle(title);
        todo.setStatus(status);
        todo.setCreatedAt(System.currentTimeMillis());
        todo.setUpdatedAt(System.currentTimeMillis());
        
        todos.add(todo);
        
        System.out.println("TODOが追加されました。");
    }
    
    static void deleteTodo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("削除するTODOのIDを入力してください: ");
        int id = scanner.nextInt();
        
        for (ToDo todo : todos) {
            if (todo.getId() == id) {
                todos.remove(todo);
                System.out.println("TODOが削除されました。");
                return;
            }
        }
        
        System.out.println("該当するTODOが見つかりませんでした。");
    }
    
    static void editTodo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("編集するTODOのIDを入力してください: ");
        int id = scanner.nextInt();
        
        for (ToDo todo : todos) {
            if (todo.getId() == id) {
                System.out.print("新しいTODOのタイトルを入力してください: ");
                String newTitle = scanner.next();
                
                System.out.println("ステータスを選択してください:");
                System.out.println("1. 未着手");
                System.out.println("2. 進行中");
                System.out.println("3. 完了");
                System.out.print("ステータス番号を入力してください: ");
                int statusChoice = scanner.nextInt();
                String newStatus;
                switch (statusChoice) {
                    case 1:
                        newStatus = "未着手";
                        break;
                    case 2:
                        newStatus = "進行中";
                        break;
                    case 3:
                        newStatus = "完了";
                        break;
                    default:
                        System.out.println("無効なステータス番号です。未着手として登録します。");
                        newStatus = "未着手";
                }
                
                todo.setTitle(newTitle);
                todo.setStatus(newStatus);
                todo.setUpdatedAt(System.currentTimeMillis());
                System.out.println("TODOが編集されました。");
                return;
            }
        }
        
        System.out.println("該当するTODOが見つかりませんでした。");
    }
    
    static void displayTodos() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        for (ToDo todo : todos) {
            System.out.println("ID: " + todo.getId());
            System.out.println("タイトル: " + todo.getTitle());
            System.out.println("ステータス: " + todo.getStatus());
            System.out.println("作成日時: " + sdf.format(todo.getCreatedAt()));
            System.out.println("更新日時: " + sdf.format(todo.getUpdatedAt()));
            System.out.println();
        }
    }
}

class ToDo {
    private int id;
    private String title;
    private String status;
    private long createdAt;
    private long updatedAt;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    
    public long getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
