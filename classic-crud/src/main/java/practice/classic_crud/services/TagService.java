package practice.classic_crud.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.Tag;
import practice.classic_crud.model.dto.TagDto;
import practice.classic_crud.repo.PostRepository;
import practice.classic_crud.repo.TagRepository;

@Service
@AllArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    private final PostRepository postRepository;

    @Transactional
    public void addTagToPost(Long postId, TagDto dto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        System.out.println(post);

//        // Проверяем существование тега
//        Tag tag = tagRepository.findByName(dto.getName()).orElse(null);
//
//        if (tag == null) {
//            // Создаем новый тег
//            tag = new Tag();
//            tag.setName(dto.getName());
//            tag = tagRepository.save(tag);
//        }
//
//        // Добавляем связь с обеих сторон
//        if (!post.getTags().contains(tag)) {
//            post.getTags().add(tag);
//            tag.getPosts().add(post); // ← важно обновить обратную связь!
//        }
//
//        postRepository.save(post); // ← сохраняем пост с обновленной связью
//        return tag;
    }
}
