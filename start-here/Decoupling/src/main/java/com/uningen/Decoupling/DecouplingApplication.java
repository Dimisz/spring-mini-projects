package com.uningen.Decoupling;

import com.uningen.Decoupling.models.Comment;
import com.uningen.Decoupling.services.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DecouplingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DecouplingApplication.class, args);

		Comment comment = new Comment();
		comment.setAuthor("Vladimir Solovyov");
		comment.setText("Test comment with Spring Context");
		CommentService commentService = ctx.getBean(CommentService.class);
		commentService.publishComment(comment);
	}

}
