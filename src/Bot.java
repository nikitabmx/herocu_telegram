
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class Bot extends TelegramLongPollingBot  {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot((LongPollingBot) new Bot());
            //telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e){ e.printStackTrace(); }





    }



    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            if ( message.getText().equals("/help")){
                sendMsg(message, "прифки");
            } else {
                sendMsg(message, "Тестовый бот");
            }

        }


    }




    private void sendMsg(Message message, String s){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e){e.printStackTrace();}
    }




    @Override
    public String getBotUsername() {
        return "NikitaBmxBot";
    }



    @Override
    public String getBotToken() {
        return "613295207:AAHBYkqh29DxeusO7rqFoOZ0SeVatpVYIYk";
    }



}
