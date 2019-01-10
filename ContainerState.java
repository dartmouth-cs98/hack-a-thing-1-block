package java_bootcamp;

import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ContainerState implements ContractState {
    private int depth;
    private int width;
    private int height;

    private String contents;
    private Party owner;
    private Party holder;

    public ContainerState() {
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return null;
    }
    public static void main(String[] Args){
        ContainerState container= new ContainerState();
    }
}
