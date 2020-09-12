package by.training.finalproject.entity;

import by.training.finalproject.entity.infoEnum.ObtainingMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Purchase implements Entity {
    private Integer id;
    private User user;
    private State state;
    private String address;
    private LocalAddress localAddress;
    private LocalDate date;
    private ObtainingMethod obtainingMethod;

    public enum State {
        ADDED("добавлен"),
        ORDERED("заказан"),
        DELIVERED("доставлен");

        private String name;

        State(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getIdentity() {
            return ordinal();
        }

        public static State getByIdentity(Integer identity) {
            return State.values()[identity];
        }

        public static State getByName(String name) {
            for (State s : State.values()) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
            return null;
        }

    }
}
