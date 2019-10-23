package afornalik.utils;


import afornalik.utils.exception.ExtensionNotSupportedException;

public interface Checkable {

    void checkTheExtension() throws ExtensionNotSupportedException;

    void setNextChain(FileExtension nextChain);
}
