package io.intercom.android.sdk.helpcenter.utils.networking;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0004\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "T", "", "()V", "ClientError", "NetworkError", "ServerError", "Success", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$ClientError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$NetworkError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$ServerError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$Success;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkResponse.kt */
public abstract class NetworkResponse<T> {
    public /* synthetic */ NetworkResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NetworkResponse() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$Success;", "T", "", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "body", "(Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$Success;", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkResponse.kt */
    public static final class Success<T> extends NetworkResponse<T> {
        public static final int $stable = 0;
        private final T body;

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.body;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.body;
        }

        public final Success<T> copy(T t) {
            Intrinsics.checkNotNullParameter(t, SDKConstants.PARAM_A2U_BODY);
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.body, (Object) ((Success) obj).body);
        }

        public int hashCode() {
            return this.body.hashCode();
        }

        public String toString() {
            return "Success(body=" + this.body + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(T t) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(t, SDKConstants.PARAM_A2U_BODY);
            this.body = t;
        }

        public final T getBody() {
            return this.body;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$ServerError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkResponse.kt */
    public static final class ServerError extends NetworkResponse {
        public static final int $stable = 0;
        private final int code;

        public static /* synthetic */ ServerError copy$default(ServerError serverError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = serverError.code;
            }
            return serverError.copy(i);
        }

        public final int component1() {
            return this.code;
        }

        public final ServerError copy(int i) {
            return new ServerError(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ServerError) && this.code == ((ServerError) obj).code;
        }

        public int hashCode() {
            return this.code;
        }

        public String toString() {
            return "ServerError(code=" + this.code + ')';
        }

        public ServerError(int i) {
            super((DefaultConstructorMarker) null);
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$NetworkError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "error", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getError", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkResponse.kt */
    public static final class NetworkError extends NetworkResponse {
        public static final int $stable = 8;
        private final IOException error;

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = networkError.error;
            }
            return networkError.copy(iOException);
        }

        public final IOException component1() {
            return this.error;
        }

        public final NetworkError copy(IOException iOException) {
            Intrinsics.checkNotNullParameter(iOException, "error");
            return new NetworkError(iOException);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NetworkError) && Intrinsics.areEqual((Object) this.error, (Object) ((NetworkError) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "NetworkError(error=" + this.error + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkError(IOException iOException) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(iOException, "error");
            this.error = iOException;
        }

        public final IOException getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse$ClientError;", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkResponse.kt */
    public static final class ClientError extends NetworkResponse {
        public static final int $stable = 8;
        private final Throwable error;

        public static /* synthetic */ ClientError copy$default(ClientError clientError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = clientError.error;
            }
            return clientError.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final ClientError copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
            return new ClientError(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClientError) && Intrinsics.areEqual((Object) this.error, (Object) ((ClientError) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "ClientError(error=" + this.error + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClientError(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
