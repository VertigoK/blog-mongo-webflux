package kevin.study.blogmongowebflux.mongo;

import kevin.study.blogmongowebflux.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BoardMongoEventListener extends AbstractMongoEventListener<Board> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Board> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(Board.SEQUENCE_NAME));
    }
}
