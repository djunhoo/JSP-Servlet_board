package article.service;

import article.model.Article;

public class PremissionChecker {
	public static boolean conModify(String userId, Article article) {
		return article.getWriter().getId().equals(userId);
	}
}
