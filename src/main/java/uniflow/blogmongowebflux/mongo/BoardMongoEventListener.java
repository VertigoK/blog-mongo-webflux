package uniflow.blogmongowebflux.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import uniflow.blogmongowebflux.domain.Board;

@RequiredArgsConstructor
@Component
public class BoardMongoEventListener extends AbstractMongoEventListener<Board> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Board> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(Board.SEQUENCE_NAME));
    }
}
