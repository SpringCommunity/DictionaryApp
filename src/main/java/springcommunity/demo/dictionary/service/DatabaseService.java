package springcommunity.demo.dictionary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springcommunity.demo.dictionary.domain.*;

@Service
public interface DatabaseService {
      public List<Word> findAllWord();
      public List<Word> findWordsByCate(int cateId);
      public List<Word> findWordsByType(int typeId);
      public List<Type> findAllType();
      public List<Category> findAllCategory();
      public int createNewWord(Word word);
      public int updateAWord(Word word);
      public int deleteAWord(int id);
      public List<Word> findWordsByCateAndType(int categoryId, int typeId);
      public List<Word> findByKeyword(String word);
      public Word findWordById(int id);
}
