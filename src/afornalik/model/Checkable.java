package afornalik.model;


import afornalik.model.exception.ExtensionNotSupportedException;

public interface Checkable {

    void checkTheExtension() throws ExtensionNotSupportedException;

    void setNextChain(FileExtension nextChain);
}
