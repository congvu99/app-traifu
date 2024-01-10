package coil.decode;

import coil.decode.ImageSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/decode/AssetMetadata;", "Lcoil/decode/ImageSource$Metadata;", "fileName", "", "(Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageSource.kt */
public final class AssetMetadata extends ImageSource.Metadata {
    private final String fileName;

    public AssetMetadata(String str) {
        this.fileName = str;
    }

    public final String getFileName() {
        return this.fileName;
    }
}