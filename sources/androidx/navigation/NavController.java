package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Å\u00012\u00020\u0001:\u0006Å\u0001Æ\u0001Ç\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010p\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\b\u0010r\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0015\u001a\u00020\u00072\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u0010\u0010t\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0012\u0010v\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0010\u0010v\u001a\u0002062\u0006\u0010x\u001a\u00020 H\u0007J\u0012\u0010y\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0003J\b\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u000206H\u0002J\u0010\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u000206H\u0017J\u0014\u0010\u001a\u0004\u0018\u0001022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0013\u0010\u001a\u0004\u0018\u0001022\u0007\u0010\u0001\u001a\u00020 H\u0007J\u0015\u0010\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u001fH\u0016J\u000f\u0010\u0001\u001a\u00020\u00072\u0006\u0010x\u001a\u00020 J\u0015\u0010\u0001\u001a\u00030\u00012\t\b\u0001\u0010\u0001\u001a\u00020\u001fH\u0016J\u0015\u0010\u0001\u001a\u0002062\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J \u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018H\u0002J\u001b\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J+\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J4\u0010\u0001\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0003J\u0013\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J\u001d\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0017J\u0014\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001fH\u0017J\u001f\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\H\u0017J+\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J7\u0010\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0017J-\u0010\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J+\u0010\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\u001a\u0010\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u000206H\u0017J\u0014\u0010 \u0001\u001a\u00020\u00162\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0003J\t\u0010¢\u0001\u001a\u000206H\u0017J\u001c\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\u0006\u0010x\u001a\u00020 2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0007J'\u0010¥\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160§\u0001H\u0000¢\u0006\u0003\b¨\u0001J'\u0010©\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0003J-\u0010ª\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\t\b\u0002\u0010¤\u0001\u001a\u0002062\u000f\b\u0002\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0002J\u0015\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0000¢\u0006\u0003\b­\u0001J\u0011\u0010®\u0001\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0014\u0010¯\u0001\u001a\u00020\u00162\t\u0010°\u0001\u001a\u0004\u0018\u00010\\H\u0017J5\u0010±\u0001\u001a\u0002062\u0007\u0010²\u0001\u001a\u00020\u001f2\t\u0010\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u001b\u0010@\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\t2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0013\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001fH\u0017J\u001e\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001f2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0012\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020MH\u0017J\u0012\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020`H\u0017J\u0013\u0010¸\u0001\u001a\u00020\u00162\b\u0010¹\u0001\u001a\u00030º\u0001H\u0017J\t\u0010»\u0001\u001a\u000206H\u0002J\t\u0010¼\u0001\u001a\u000206H\u0002J\u001a\u0010½\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b¾\u0001J\u000f\u0010¿\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\bÀ\u0001J\t\u0010Á\u0001\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u0004\u0018\u000102*\u0002022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0002Jb\u0010Â\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012H\u0002JL\u0010©\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\u0006\u0010g\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u0002062$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00160\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188WX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eX\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u001eX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t8W@WX\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020C8@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020I8VX\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR$\u0010S\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b8V@WX\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002020Y\u0012\b\u0012\u00060ZR\u00020\u00000\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020e0\u001eX\u0004¢\u0006\u0002\n\u0000R+\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010,R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006È\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/navigation/NavBackStackEntry;", "_graph", "Landroidx/navigation/NavGraph;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "_visibleEntries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "activity", "Landroid/app/Activity;", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "", "backQueue", "Lkotlin/collections/ArrayDeque;", "getBackQueue", "()Lkotlin/collections/ArrayDeque;", "backStackEntriesToDispatch", "", "backStackMap", "", "", "", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "backStackToRestore", "", "Landroid/os/Parcelable;", "[Landroid/os/Parcelable;", "childToParentEntries", "getContext", "()Landroid/content/Context;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentDestination", "Landroidx/navigation/NavDestination;", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "deepLinkHandled", "", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "dispatchReentrantCount", "enableOnBackPressedCallback", "entrySavedState", "graph", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "inflater", "Landroidx/navigation/NavInflater;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorStateToRestore", "Landroid/os/Bundle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "parentToChildCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "popFromBackStackHandler", "popUpTo", "previousBackStackEntry", "getPreviousBackStackEntry", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "visibleEntries", "Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "addEntryToBackStack", "node", "finalArgs", "restoredEntries", "addOnDestinationChangedListener", "listener", "clearBackStack", "destinationId", "route", "clearBackStackInternal", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "dispatchOnDestinationChanged", "enableOnBackPressed", "enabled", "findDestination", "destinationRoute", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "getBackStackEntry", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "handleDeepLink", "intent", "Landroid/content/Intent;", "instantiateBackStack", "backStackState", "linkChildToParent", "child", "parent", "navigate", "Landroid/net/Uri;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "args", "directions", "Landroidx/navigation/NavDirections;", "resId", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigateUp", "onGraphCreated", "startDestinationArgs", "popBackStack", "inclusive", "saveState", "popBackStackFromNavigator", "onComplete", "Lkotlin/Function0;", "popBackStackFromNavigator$navigation_runtime_release", "popBackStackInternal", "popEntryFromBackStack", "savedState", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "removeOnDestinationChangedListener", "restoreState", "navState", "restoreStateInternal", "id", "graphResId", "setLifecycleOwner", "owner", "setOnBackPressedDispatcher", "dispatcher", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "updateOnBackPressedCallbackEnabled", "navigateInternal", "entries", "handler", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavController.kt */
public class NavController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    /* access modifiers changed from: private */
    public static boolean deepLinkSaveState = true;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    /* access modifiers changed from: private */
    public NavigatorProvider _navigatorProvider;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    /* access modifiers changed from: private */
    public Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    /* access modifiers changed from: private */
    public final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    /* access modifiers changed from: private */
    public final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    /* access modifiers changed from: private */
    public NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final Lazy navInflater$delegate;
    /* access modifiers changed from: private */
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    /* access modifiers changed from: private */
    public Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    /* access modifiers changed from: private */
    public NavControllerViewModel viewModel;
    private final StateFlow<List<NavBackStackEntry>> visibleEntries;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NavController.kt */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    @JvmStatic
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean z) {
        Companion.enableDeepLinkSaveState(z);
    }

    public final void navigate(String str) {
        Intrinsics.checkNotNullParameter(str, "route");
        navigate$default(this, str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public final void navigate(String str, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(str, "route");
        navigate$default(this, str, navOptions, (Navigator.Extras) null, 4, (Object) null);
    }

    public final boolean popBackStack(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "route");
        return popBackStack$default(this, str, z, false, 4, (Object) null);
    }

    public NavController(Context context2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Iterator it = SequencesKt.generateSequence(context2, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.activity = (Activity) obj;
        this.backQueue = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._visibleEntries = MutableStateFlow;
        this.visibleEntries = FlowKt.asStateFlow(MutableStateFlow);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList<>();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new LifecycleEventObserver() {
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.m4971lifecycleObserver$lambda2(NavController.this, lifecycleOwner, event);
            }
        };
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = LazyKt.lazy(new NavController$navInflater$2(this));
        MutableSharedFlow<NavBackStackEntry> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this._currentBackStackEntryFlow = MutableSharedFlow$default;
        this.currentBackStackEntryFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final Context getContext() {
        return this.context;
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        } else if (navGraph != null) {
            return navGraph;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
        }
    }

    public void setGraph(NavGraph navGraph) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        setGraph(navGraph, (Bundle) null);
    }

    public ArrayDeque<NavBackStackEntry> getBackQueue() {
        return this.backQueue;
    }

    public final StateFlow<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    private final void linkChildToParent(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        if (this.parentToChildCount.get(navBackStackEntry2) == null) {
            this.parentToChildCount.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(navBackStackEntry2);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "child");
        NavBackStackEntry remove = this.childToParentEntries.remove(navBackStackEntry);
        Integer num = null;
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.parentToChildCount.get(remove);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(remove.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.markTransitionComplete(remove);
            }
            this.parentToChildCount.remove(remove);
        }
        return remove;
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.hostLifecycleState = state;
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    /* access modifiers changed from: private */
    /* renamed from: lifecycleObserver$lambda-2  reason: not valid java name */
    public static final void m4971lifecycleObserver$lambda2(NavController navController, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(navController, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "event.targetState");
        navController.hostLifecycleState = targetState;
        if (navController._graph != null) {
            Iterator it = navController.getBackQueue().iterator();
            while (it.hasNext()) {
                ((NavBackStackEntry) it.next()).handleLifecycleEvent(event);
            }
        }
    }

    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    public void setNavigatorProvider(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        if (getBackQueue().isEmpty()) {
            this._navigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
    }

    static /* synthetic */ void navigateInternal$default(NavController navController, Navigator navigator, List list, NavOptions navOptions, Navigator.Extras extras, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                function1 = NavController$navigateInternal$1.INSTANCE;
            }
            navController.navigateInternal(navigator, list, navOptions, extras, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }

    private final void navigateInternal(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.Extras extras, Function1<? super NavBackStackEntry, Unit> function1) {
        this.addToBackStackHandler = function1;
        navigator.navigate(list, navOptions, extras);
        this.addToBackStackHandler = null;
    }

    static /* synthetic */ void popBackStackInternal$default(NavController navController, Navigator navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                function1 = NavController$popBackStackInternal$1.INSTANCE;
            }
            navController.popBackStackInternal(navigator, navBackStackEntry, z, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z, Function1<? super NavBackStackEntry, Unit> function1) {
        this.popFromBackStackHandler = function1;
        navigator.popBackStack(navBackStackEntry, z);
        this.popFromBackStackHandler = null;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "addInternal", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "createBackStackEntry", "destination", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "entry", "pop", "popUpTo", "saveState", "", "popWithTransition", "push", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NavController.kt */
    private final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator2) {
            Intrinsics.checkNotNullParameter(navigator2, "navigator");
            this.this$0 = navController;
            this.navigator = navigator2;
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        public void push(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getAddToBackStackHandler$p = this.this$0.addToBackStackHandler;
                if (access$getAddToBackStackHandler$p != null) {
                    access$getAddToBackStackHandler$p.invoke(navBackStackEntry);
                    addInternal(navBackStackEntry);
                    return;
                }
                Log.i(NavController.TAG, "Ignoring add of destination " + navBackStackEntry.getDestination() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.getDestination().getNavigatorName() + " should already be created").toString());
        }

        public final void addInternal(NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
            super.push(navBackStackEntry);
        }

        public NavBackStackEntry createBackStackEntry(NavDestination navDestination, Bundle bundle) {
            Intrinsics.checkNotNullParameter(navDestination, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), navDestination, bundle, this.this$0.getHostLifecycleState$navigation_runtime_release(), this.this$0.viewModel, (String) null, (Bundle) null, 96, (Object) null);
        }

        public void pop(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            Navigator navigator2 = this.this$0._navigatorProvider.getNavigator(navBackStackEntry.getDestination().getNavigatorName());
            if (Intrinsics.areEqual((Object) navigator2, (Object) this.navigator)) {
                Function1 access$getPopFromBackStackHandler$p = this.this$0.popFromBackStackHandler;
                if (access$getPopFromBackStackHandler$p != null) {
                    access$getPopFromBackStackHandler$p.invoke(navBackStackEntry);
                    super.pop(navBackStackEntry, z);
                    return;
                }
                this.this$0.popBackStackFromNavigator$navigation_runtime_release(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z));
                return;
            }
            Object obj = this.this$0.navigatorState.get(navigator2);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).pop(navBackStackEntry, z);
        }

        public void popWithTransition(NavBackStackEntry navBackStackEntry, boolean z) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
            super.popWithTransition(navBackStackEntry, z);
            this.this$0.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
        }

        public void markTransitionComplete(NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel access$getViewModel$p;
            Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
            boolean z = true;
            boolean areEqual = Intrinsics.areEqual(this.this$0.entrySavedState.get(navBackStackEntry), (Object) true);
            super.markTransitionComplete(navBackStackEntry);
            this.this$0.entrySavedState.remove(navBackStackEntry);
            if (!this.this$0.getBackQueue().contains(navBackStackEntry)) {
                this.this$0.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                Iterable backQueue = this.this$0.getBackQueue();
                if (!(backQueue instanceof Collection) || !((Collection) backQueue).isEmpty()) {
                    Iterator it = backQueue.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) it.next()).getId(), (Object) navBackStackEntry.getId())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z && !areEqual && (access$getViewModel$p = this.this$0.viewModel) != null) {
                    access$getViewModel$p.clear(navBackStackEntry.getId());
                }
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            } else if (!isNavigating()) {
                this.this$0.updateBackStackLifecycle$navigation_runtime_release();
                this.this$0._visibleEntries.tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            }
        }
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.add(onDestinationChangedListener);
        if (!getBackQueue().isEmpty()) {
            NavBackStackEntry last = getBackQueue().last();
            onDestinationChangedListener.onDestinationChanged(this, last.getDestination(), last.getArguments());
        }
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        Intrinsics.checkNotNullParameter(onDestinationChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    public boolean popBackStack() {
        if (getBackQueue().isEmpty()) {
            return false;
        }
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        return popBackStack(currentDestination.getId(), true);
    }

    public boolean popBackStack(int i, boolean z) {
        return popBackStack(i, z, false);
    }

    public boolean popBackStack(int i, boolean z, boolean z2) {
        return popBackStackInternal(i, z, z2) && dispatchOnDestinationChanged();
    }

    public static /* synthetic */ boolean popBackStack$default(NavController navController, String str, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStack(str, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    public final boolean popBackStack(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "route");
        return popBackStack(NavDestination.Companion.createRoute(str).hashCode(), z, z2);
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController navController, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return navController.popBackStackInternal(i, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    private final boolean popBackStackInternal(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        int i2 = i;
        boolean z3 = z2;
        if (getBackQueue().isEmpty()) {
            return false;
        }
        List<Navigator> arrayList = new ArrayList<>();
        Iterator it = CollectionsKt.reversed(getBackQueue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination destination = ((NavBackStackEntry) it.next()).getDestination();
            Navigator navigator = this._navigatorProvider.getNavigator(destination.getNavigatorName());
            if (z || destination.getId() != i2) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i2) {
                navDestination = destination;
                break;
            }
        }
        if (navDestination == null) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(this.context, i2) + " as it was not found on the current back stack");
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator popBackStackInternal : arrayList) {
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            popBackStackInternal(popBackStackInternal, getBackQueue().last(), z3, new NavController$popBackStackInternal$2(booleanRef2, booleanRef, this, z2, arrayDeque));
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z3) {
            if (!z) {
                for (NavDestination id : SequencesKt.takeWhile(SequencesKt.generateSequence(navDestination, NavController$popBackStackInternal$3.INSTANCE), new NavController$popBackStackInternal$4(this))) {
                    Map<Integer, String> map = this.backStackMap;
                    Integer valueOf = Integer.valueOf(id.getId());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.firstOrNull();
                    map.put(valueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                for (NavDestination id2 : SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination(navBackStackEntryState2.getDestinationId()), NavController$popBackStackInternal$6.INSTANCE), new NavController$popBackStackInternal$7(this))) {
                    this.backStackMap.put(Integer.valueOf(id2.getId()), navBackStackEntryState2.getId());
                }
                this.backStackStates.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        updateOnBackPressedCallbackEnabled();
        return booleanRef.element;
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry navBackStackEntry, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "popUpTo");
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        int indexOf = getBackQueue().indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i(TAG, "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i = indexOf + 1;
        if (i != getBackQueue().size()) {
            popBackStackInternal(getBackQueue().get(i).getDestination().getId(), true, false);
        }
        popEntryFromBackStack$default(this, navBackStackEntry, false, (ArrayDeque) null, 6, (Object) null);
        function0.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    static /* synthetic */ void popEntryFromBackStack$default(NavController navController, NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                arrayDeque = new ArrayDeque();
            }
            navController.popEntryFromBackStack(navBackStackEntry, z, arrayDeque);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
        r4 = (r4 = r4.getTransitionsInProgress()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void popEntryFromBackStack(androidx.navigation.NavBackStackEntry r4, boolean r5, kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntryState> r6) {
        /*
            r3 = this;
            kotlin.collections.ArrayDeque r0 = r3.getBackQueue()
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x0095
            kotlin.collections.ArrayDeque r4 = r3.getBackQueue()
            r4.removeLast()
            androidx.navigation.NavigatorProvider r4 = r3.getNavigatorProvider()
            androidx.navigation.NavDestination r1 = r0.getDestination()
            java.lang.String r1 = r1.getNavigatorName()
            androidx.navigation.Navigator r4 = r4.getNavigator((java.lang.String) r1)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r1 = r3.navigatorState
            java.lang.Object r4 = r1.get(r4)
            androidx.navigation.NavController$NavControllerNavigatorState r4 = (androidx.navigation.NavController.NavControllerNavigatorState) r4
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0049
            kotlinx.coroutines.flow.StateFlow r4 = r4.getTransitionsInProgress()
            if (r4 == 0) goto L_0x0049
            java.lang.Object r4 = r4.getValue()
            java.util.Set r4 = (java.util.Set) r4
            if (r4 == 0) goto L_0x0049
            boolean r4 = r4.contains(r0)
            if (r4 != r1) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            if (r4 != 0) goto L_0x0056
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r4 = r3.parentToChildCount
            boolean r4 = r4.containsKey(r0)
            if (r4 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            androidx.lifecycle.Lifecycle r4 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r4 = r4.getCurrentState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.CREATED
            boolean r4 = r4.isAtLeast(r2)
            if (r4 == 0) goto L_0x0085
            if (r5 == 0) goto L_0x0075
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.CREATED
            r0.setMaxLifecycle(r4)
            androidx.navigation.NavBackStackEntryState r4 = new androidx.navigation.NavBackStackEntryState
            r4.<init>((androidx.navigation.NavBackStackEntry) r0)
            r6.addFirst(r4)
        L_0x0075:
            if (r1 != 0) goto L_0x0080
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.DESTROYED
            r0.setMaxLifecycle(r4)
            r3.unlinkChildFromParent$navigation_runtime_release(r0)
            goto L_0x0085
        L_0x0080:
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.CREATED
            r0.setMaxLifecycle(r4)
        L_0x0085:
            if (r5 != 0) goto L_0x0094
            if (r1 != 0) goto L_0x0094
            androidx.navigation.NavControllerViewModel r4 = r3.viewModel
            if (r4 == 0) goto L_0x0094
            java.lang.String r5 = r0.getId()
            r4.clear(r5)
        L_0x0094:
            return
        L_0x0095:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Attempted to pop "
            r5.append(r6)
            androidx.navigation.NavDestination r4 = r4.getDestination()
            r5.append(r4)
            java.lang.String r4 = ", which is not the top of the back stack ("
            r5.append(r4)
            androidx.navigation.NavDestination r4 = r0.getDestination()
            r5.append(r4)
            r4 = 41
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.popEntryFromBackStack(androidx.navigation.NavBackStackEntry, boolean, kotlin.collections.ArrayDeque):void");
    }

    public final boolean clearBackStack(String str) {
        Intrinsics.checkNotNullParameter(str, "route");
        return clearBackStack(NavDestination.Companion.createRoute(str).hashCode());
    }

    public final boolean clearBackStack(int i) {
        return clearBackStackInternal(i) && dispatchOnDestinationChanged();
    }

    private final boolean clearBackStackInternal(int i) {
        for (NavControllerNavigatorState navigating : this.navigatorState.values()) {
            navigating.setNavigating(true);
        }
        boolean restoreStateInternal = restoreStateInternal(i, (Bundle) null, (NavOptions) null, (Navigator.Extras) null);
        for (NavControllerNavigatorState navigating2 : this.navigatorState.values()) {
            navigating2.setNavigating(false);
        }
        if (!restoreStateInternal || !popBackStackInternal(i, true, false)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r0.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean navigateUp() {
        /*
            r2 = this;
            int r0 = r2.getDestinationCountOnBackStack()
            r1 = 1
            if (r0 != r1) goto L_0x002c
            android.app.Activity r0 = r2.activity
            r1 = 0
            if (r0 == 0) goto L_0x0017
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0017
            android.os.Bundle r0 = r0.getExtras()
            goto L_0x0018
        L_0x0017:
            r0 = r1
        L_0x0018:
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = "android-support-nav:controller:deepLinkIds"
            int[] r1 = r0.getIntArray(r1)
        L_0x0020:
            if (r1 == 0) goto L_0x0027
            boolean r0 = r2.tryRelaunchUpToExplicitStack()
            return r0
        L_0x0027:
            boolean r0 = r2.tryRelaunchUpToGeneratedStack()
            return r0
        L_0x002c:
            boolean r0 = r2.popBackStack()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigateUp():boolean");
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int i = 0;
        if (!this.deepLinkHandled) {
            return false;
        }
        Activity activity2 = this.activity;
        Intrinsics.checkNotNull(activity2);
        Intent intent = activity2.getIntent();
        Bundle extras = intent.getExtras();
        Intrinsics.checkNotNull(extras);
        int[] intArray = extras.getIntArray(KEY_DEEP_LINK_IDS);
        Intrinsics.checkNotNull(intArray);
        List<Integer> mutableList = ArraysKt.toMutableList(intArray);
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int intValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
        if (parcelableArrayList != null) {
            Bundle bundle = (Bundle) CollectionsKt.removeLast(parcelableArrayList);
        }
        if (mutableList.isEmpty()) {
            return false;
        }
        NavDestination findDestination = findDestination(getGraph(), intValue);
        if (findDestination instanceof NavGraph) {
            intValue = NavGraph.Companion.findStartDestination((NavGraph) findDestination).getId();
        }
        NavDestination currentDestination = getCurrentDestination();
        if (!(currentDestination != null && intValue == currentDestination.getId())) {
            return false;
        }
        NavDeepLinkBuilder createDeepLink = createDeepLink();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(KEY_DEEP_LINK_INTENT, intent));
        Bundle bundle2 = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (bundle2 != null) {
            bundleOf.putAll(bundle2);
        }
        createDeepLink.setArguments(bundleOf);
        for (Object next : mutableList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            createDeepLink.addDestination(((Number) next).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null);
            i = i2;
        }
        createDeepLink.createTaskStackBuilder().startActivities();
        Activity activity3 = this.activity;
        if (activity3 != null) {
            activity3.finish();
        }
        return true;
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination currentDestination = getCurrentDestination();
        Intrinsics.checkNotNull(currentDestination);
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestinationId() != id) {
                Bundle bundle = new Bundle();
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    Intrinsics.checkNotNull(activity2);
                    if (activity2.getIntent() != null) {
                        Activity activity3 = this.activity;
                        Intrinsics.checkNotNull(activity3);
                        if (activity3.getIntent().getData() != null) {
                            Activity activity4 = this.activity;
                            Intrinsics.checkNotNull(activity4);
                            bundle.putParcelable(KEY_DEEP_LINK_INTENT, activity4.getIntent());
                            NavGraph navGraph = this._graph;
                            Intrinsics.checkNotNull(navGraph);
                            Activity activity5 = this.activity;
                            Intrinsics.checkNotNull(activity5);
                            Intent intent = activity5.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "activity!!.intent");
                            NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(new NavDeepLinkRequest(intent));
                            if (matchDeepLink != null) {
                                bundle.putAll(matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs()));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), parent.getId(), (Bundle) null, 2, (Object) null).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity6 = this.activity;
                if (activity6 == null) {
                    return true;
                }
                activity6.finish();
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    private final int getDestinationCountOnBackStack() {
        Iterable<NavBackStackEntry> backQueue2 = getBackQueue();
        int i = 0;
        if (!(backQueue2 instanceof Collection) || !((Collection) backQueue2).isEmpty()) {
            for (NavBackStackEntry destination : backQueue2) {
                if ((!(destination.getDestination() instanceof NavGraph)) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    private final boolean dispatchOnDestinationChanged() {
        while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof NavGraph)) {
            popEntryFromBackStack$default(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull != null) {
            this.backStackEntriesToDispatch.add(lastOrNull);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList(this.backStackEntriesToDispatch);
            this.backStackEntriesToDispatch.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.onDestinationChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry);
            }
            this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
        }
        if (lastOrNull != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        r7 = (r7 = r7.getTransitionsInProgress()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBackStackLifecycle$navigation_runtime_release() {
        /*
            r11 = this;
            kotlin.collections.ArrayDeque r0 = r11.getBackQueue()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r0)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.getDestination()
            boolean r2 = r1 instanceof androidx.navigation.FloatingWindow
            r3 = 0
            if (r2 == 0) goto L_0x0044
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.reversed(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x002b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r2.next()
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.getDestination()
            boolean r5 = r4 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x002b
            boolean r5 = r4 instanceof androidx.navigation.FloatingWindow
            if (r5 != 0) goto L_0x002b
            goto L_0x0045
        L_0x0044:
            r4 = r3
        L_0x0045:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5 = r0
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = kotlin.collections.CollectionsKt.reversed(r5)
            java.util.Iterator r5 = r5.iterator()
        L_0x0055:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0115
            java.lang.Object r6 = r5.next()
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            androidx.lifecycle.Lifecycle$State r7 = r6.getMaxLifecycle()
            androidx.navigation.NavDestination r8 = r6.getDestination()
            if (r1 == 0) goto L_0x00e4
            int r9 = r8.getId()
            int r10 = r1.getId()
            if (r9 != r10) goto L_0x00e4
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 == r8) goto L_0x00dc
            androidx.navigation.NavigatorProvider r7 = r11.getNavigatorProvider()
            androidx.navigation.NavDestination r8 = r6.getDestination()
            java.lang.String r8 = r8.getNavigatorName()
            androidx.navigation.Navigator r7 = r7.getNavigator((java.lang.String) r8)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r8 = r11.navigatorState
            java.lang.Object r7 = r8.get(r7)
            androidx.navigation.NavController$NavControllerNavigatorState r7 = (androidx.navigation.NavController.NavControllerNavigatorState) r7
            if (r7 == 0) goto L_0x00aa
            kotlinx.coroutines.flow.StateFlow r7 = r7.getTransitionsInProgress()
            if (r7 == 0) goto L_0x00aa
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L_0x00aa
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x00ab
        L_0x00aa:
            r7 = r3
        L_0x00ab:
            r8 = 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r9)
            if (r7 != 0) goto L_0x00d4
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r7 = r11.parentToChildCount
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            r9 = 0
            if (r7 == 0) goto L_0x00c8
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r8 = 0
        L_0x00c9:
            if (r8 != 0) goto L_0x00d4
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            r7.put(r6, r8)
            goto L_0x00dc
        L_0x00d4:
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            r7.put(r6, r8)
        L_0x00dc:
            androidx.navigation.NavGraph r1 = r1.getParent()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            goto L_0x0055
        L_0x00e4:
            if (r4 == 0) goto L_0x010e
            int r8 = r8.getId()
            int r9 = r4.getId()
            if (r8 != r9) goto L_0x010e
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 != r8) goto L_0x00fa
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r6.setMaxLifecycle(r7)
            goto L_0x0106
        L_0x00fa:
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            if (r7 == r8) goto L_0x0106
            r7 = r2
            java.util.Map r7 = (java.util.Map) r7
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            r7.put(r6, r8)
        L_0x0106:
            androidx.navigation.NavGraph r4 = r4.getParent()
            androidx.navigation.NavDestination r4 = (androidx.navigation.NavDestination) r4
            goto L_0x0055
        L_0x010e:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED
            r6.setMaxLifecycle(r7)
            goto L_0x0055
        L_0x0115:
            java.util.Iterator r0 = r0.iterator()
        L_0x0119:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0135
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            java.lang.Object r3 = r2.get(r1)
            androidx.lifecycle.Lifecycle$State r3 = (androidx.lifecycle.Lifecycle.State) r3
            if (r3 == 0) goto L_0x0131
            r1.setMaxLifecycle(r3)
            goto L_0x0119
        L_0x0131:
            r1.updateState()
            goto L_0x0119
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateBackStackLifecycle$navigation_runtime_release():void");
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        List arrayList = new ArrayList();
        for (NavControllerNavigatorState transitionsInProgress : this.navigatorState.values()) {
            Collection collection = arrayList;
            Collection arrayList2 = new ArrayList();
            for (Object next : transitionsInProgress.getTransitionsInProgress().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(next);
                }
            }
            CollectionsKt.addAll(collection, (List) arrayList2);
        }
        Collection collection2 = arrayList;
        Collection arrayList3 = new ArrayList();
        for (Object next2 : getBackQueue()) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(next2);
            }
        }
        CollectionsKt.addAll(collection2, (List) arrayList3);
        Collection arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).getDestination() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return (List) arrayList4;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    public void setGraph(int i) {
        setGraph(getNavInflater().inflate(i), (Bundle) null);
    }

    public void setGraph(int i, Bundle bundle) {
        setGraph(getNavInflater().inflate(i), bundle);
    }

    public void setGraph(NavGraph navGraph, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navGraph, "graph");
        if (!Intrinsics.areEqual((Object) this._graph, (Object) navGraph)) {
            NavGraph navGraph2 = this._graph;
            if (navGraph2 != null) {
                for (Integer num : new ArrayList(this.backStackMap.keySet())) {
                    Intrinsics.checkNotNullExpressionValue(num, "id");
                    clearBackStackInternal(num.intValue());
                }
                popBackStackInternal$default(this, navGraph2.getId(), true, false, 4, (Object) null);
            }
            this._graph = navGraph;
            onGraphCreated(bundle);
            return;
        }
        int size = navGraph.getNodes().size();
        for (int i = 0; i < size; i++) {
            NavDestination valueAt = navGraph.getNodes().valueAt(i);
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navGraph3.getNodes().replace(i, valueAt);
            Collection arrayList = new ArrayList();
            for (Object next : getBackQueue()) {
                if (valueAt != null && ((NavBackStackEntry) next).getDestination().getId() == valueAt.getId()) {
                    arrayList.add(next);
                }
            }
            for (NavBackStackEntry destination : (List) arrayList) {
                Intrinsics.checkNotNullExpressionValue(valueAt, "newDestination");
                destination.setDestination(valueAt);
            }
        }
    }

    private final void onGraphCreated(Bundle bundle) {
        Activity activity2;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.navigatorStateToRestore;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                NavigatorProvider navigatorProvider = this._navigatorProvider;
                Intrinsics.checkNotNullExpressionValue(next, "name");
                Navigator navigator = navigatorProvider.getNavigator(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.backStackToRestore;
        boolean z = false;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i = 0;
            while (i < length) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i];
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    Navigator navigator2 = this._navigatorProvider.getNavigator(findDestination.getNavigatorName());
                    Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.navigatorState;
                    NavControllerNavigatorState navControllerNavigatorState = map.get(navigator2);
                    if (navControllerNavigatorState == null) {
                        navControllerNavigatorState = new NavControllerNavigatorState(this, navigator2);
                        map.put(navigator2, navControllerNavigatorState);
                    }
                    getBackQueue().add(instantiate);
                    navControllerNavigatorState.addInternal(instantiate);
                    NavGraph parent = instantiate.getDestination().getParent();
                    if (parent != null) {
                        linkChildToParent(instantiate, getBackStackEntry(parent.getId()));
                    }
                    i++;
                } else {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + displayName + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.backStackToRestore = null;
        }
        Collection arrayList = new ArrayList();
        for (Object next2 : this._navigatorProvider.getNavigators().values()) {
            if (!((Navigator) next2).isAttached()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator3 : (List) arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.navigatorState;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator3);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(this, navigator3);
                map2.put(navigator3, navControllerNavigatorState2);
            }
            navigator3.onAttach(navControllerNavigatorState2);
        }
        if (this._graph == null || !getBackQueue().isEmpty()) {
            dispatchOnDestinationChanged();
            return;
        }
        if (!this.deepLinkHandled && (activity2 = this.activity) != null) {
            Intrinsics.checkNotNull(activity2);
            if (handleDeepLink(activity2.getIntent())) {
                z = true;
            }
        }
        if (!z) {
            NavGraph navGraph = this._graph;
            Intrinsics.checkNotNull(navGraph);
            navigate((NavDestination) navGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if ((r2.length == 0) != false) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleDeepLink(android.content.Intent r20) {
        /*
            r19 = this;
            r6 = r19
            r0 = r20
            r7 = 0
            if (r0 != 0) goto L_0x0008
            return r7
        L_0x0008:
            android.os.Bundle r1 = r20.getExtras()
            r8 = 0
            if (r1 == 0) goto L_0x0016
            java.lang.String r2 = "android-support-nav:controller:deepLinkIds"
            int[] r2 = r1.getIntArray(r2)
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            if (r1 == 0) goto L_0x0020
            java.lang.String r3 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r3 = r1.getParcelableArrayList(r3)
            goto L_0x0021
        L_0x0020:
            r3 = r8
        L_0x0021:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 == 0) goto L_0x002f
            java.lang.String r5 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r1 = r1.getBundle(r5)
            goto L_0x0030
        L_0x002f:
            r1 = r8
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r4.putAll(r1)
        L_0x0035:
            r9 = 1
            if (r2 == 0) goto L_0x0040
            int r1 = r2.length
            if (r1 != 0) goto L_0x003d
            r1 = 1
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            if (r1 == 0) goto L_0x0068
        L_0x0040:
            androidx.navigation.NavGraph r1 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavDeepLinkRequest r5 = new androidx.navigation.NavDeepLinkRequest
            r5.<init>(r0)
            androidx.navigation.NavDestination$DeepLinkMatch r1 = r1.matchDeepLink(r5)
            if (r1 == 0) goto L_0x0068
            androidx.navigation.NavDestination r2 = r1.getDestination()
            int[] r3 = androidx.navigation.NavDestination.buildDeepLinkIds$default(r2, r8, r9, r8)
            android.os.Bundle r1 = r1.getMatchingArgs()
            android.os.Bundle r1 = r2.addInDefaultArgs(r1)
            if (r1 == 0) goto L_0x0065
            r4.putAll(r1)
        L_0x0065:
            r10 = r3
            r3 = r8
            goto L_0x0069
        L_0x0068:
            r10 = r2
        L_0x0069:
            if (r10 == 0) goto L_0x01ee
            int r1 = r10.length
            if (r1 != 0) goto L_0x0070
            r1 = 1
            goto L_0x0071
        L_0x0070:
            r1 = 0
        L_0x0071:
            if (r1 == 0) goto L_0x0075
            goto L_0x01ee
        L_0x0075:
            java.lang.String r1 = r6.findInvalidDestinationDisplayNameInDeepLink(r10)
            if (r1 == 0) goto L_0x009a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not find destination "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " in the navigation graph, ignoring the deep link from "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "NavController"
            android.util.Log.i(r1, r0)
            return r7
        L_0x009a:
            r1 = r0
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            java.lang.String r2 = "android-support-nav:controller:deepLinkIntent"
            r4.putParcelable(r2, r1)
            int r1 = r10.length
            android.os.Bundle[] r11 = new android.os.Bundle[r1]
            r2 = 0
        L_0x00a6:
            if (r2 >= r1) goto L_0x00c2
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putAll(r4)
            if (r3 == 0) goto L_0x00bd
            java.lang.Object r12 = r3.get(r2)
            android.os.Bundle r12 = (android.os.Bundle) r12
            if (r12 == 0) goto L_0x00bd
            r5.putAll(r12)
        L_0x00bd:
            r11[r2] = r5
            int r2 = r2 + 1
            goto L_0x00a6
        L_0x00c2:
            int r1 = r20.getFlags()
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00f1
            r3 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r3
            if (r1 != 0) goto L_0x00f1
            r0.addFlags(r3)
            android.content.Context r1 = r6.context
            androidx.core.app.TaskStackBuilder r1 = androidx.core.app.TaskStackBuilder.create(r1)
            androidx.core.app.TaskStackBuilder r0 = r1.addNextIntentWithParentStack(r0)
            java.lang.String r1 = "create(context)\n        …ntWithParentStack(intent)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0.startActivities()
            android.app.Activity r0 = r6.activity
            if (r0 == 0) goto L_0x00f0
            r0.finish()
            r0.overridePendingTransition(r7, r7)
        L_0x00f0:
            return r9
        L_0x00f1:
            java.lang.String r12 = "Deep Linking failed: destination "
            if (r2 == 0) goto L_0x015a
            kotlin.collections.ArrayDeque r0 = r19.getBackQueue()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0111
            androidx.navigation.NavGraph r0 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r0.getId()
            r2 = 1
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r19
            popBackStackInternal$default(r0, r1, r2, r3, r4, r5)
        L_0x0111:
            int r0 = r10.length
            if (r7 >= r0) goto L_0x0159
            r0 = r10[r7]
            int r1 = r7 + 1
            r2 = r11[r7]
            androidx.navigation.NavDestination r3 = r6.findDestination((int) r0)
            if (r3 == 0) goto L_0x0130
            androidx.navigation.NavController$handleDeepLink$2 r0 = new androidx.navigation.NavController$handleDeepLink$2
            r0.<init>(r3, r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.navigation.NavOptions r0 = androidx.navigation.NavOptionsBuilderKt.navOptions(r0)
            r6.navigate((androidx.navigation.NavDestination) r3, (android.os.Bundle) r2, (androidx.navigation.NavOptions) r0, (androidx.navigation.Navigator.Extras) r8)
            r7 = r1
            goto L_0x0111
        L_0x0130:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r6.context
            java.lang.String r0 = r1.getDisplayName(r2, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = " cannot be found from the current destination "
            r2.append(r0)
            androidx.navigation.NavDestination r0 = r19.getCurrentDestination()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0159:
            return r9
        L_0x015a:
            androidx.navigation.NavGraph r0 = r6._graph
            int r1 = r10.length
            r2 = 0
        L_0x015e:
            if (r2 >= r1) goto L_0x01eb
            r3 = r10[r2]
            r4 = r11[r2]
            if (r2 != 0) goto L_0x016b
            androidx.navigation.NavGraph r5 = r6._graph
            androidx.navigation.NavDestination r5 = (androidx.navigation.NavDestination) r5
            goto L_0x0172
        L_0x016b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.navigation.NavDestination r5 = r0.findNode((int) r3)
        L_0x0172:
            if (r5 == 0) goto L_0x01c6
            int r3 = r10.length
            int r3 = r3 - r9
            if (r2 == r3) goto L_0x019b
            boolean r3 = r5 instanceof androidx.navigation.NavGraph
            if (r3 == 0) goto L_0x01c3
            androidx.navigation.NavGraph r5 = (androidx.navigation.NavGraph) r5
        L_0x017e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r0 = r5.getStartDestinationId()
            androidx.navigation.NavDestination r0 = r5.findNode((int) r0)
            boolean r0 = r0 instanceof androidx.navigation.NavGraph
            if (r0 == 0) goto L_0x0199
            int r0 = r5.getStartDestinationId()
            androidx.navigation.NavDestination r0 = r5.findNode((int) r0)
            r5 = r0
            androidx.navigation.NavGraph r5 = (androidx.navigation.NavGraph) r5
            goto L_0x017e
        L_0x0199:
            r0 = r5
            goto L_0x01c3
        L_0x019b:
            androidx.navigation.NavOptions$Builder r13 = new androidx.navigation.NavOptions$Builder
            r13.<init>()
            androidx.navigation.NavGraph r3 = r6._graph
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r14 = r3.getId()
            r15 = 1
            r16 = 0
            r17 = 4
            r18 = 0
            androidx.navigation.NavOptions$Builder r3 = androidx.navigation.NavOptions.Builder.setPopUpTo$default((androidx.navigation.NavOptions.Builder) r13, (int) r14, (boolean) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            androidx.navigation.NavOptions$Builder r3 = r3.setEnterAnim(r7)
            androidx.navigation.NavOptions$Builder r3 = r3.setExitAnim(r7)
            androidx.navigation.NavOptions r3 = r3.build()
            r6.navigate((androidx.navigation.NavDestination) r5, (android.os.Bundle) r4, (androidx.navigation.NavOptions) r3, (androidx.navigation.Navigator.Extras) r8)
        L_0x01c3:
            int r2 = r2 + 1
            goto L_0x015e
        L_0x01c6:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r6.context
            java.lang.String r1 = r1.getDisplayName(r2, r3)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r1)
            java.lang.String r1 = " cannot be found in graph "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01eb:
            r6.deepLinkHandled = r9
            return r9
        L_0x01ee:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.handleDeepLink(android.content.Intent):boolean");
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this._graph;
        int length = iArr.length;
        int i = 0;
        while (true) {
            NavGraph navGraph3 = null;
            if (i >= length) {
                return null;
            }
            int i2 = iArr[i];
            if (i == 0) {
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                if (navGraph4.getId() == i2) {
                    navGraph3 = this._graph;
                }
                navDestination = navGraph3;
            } else {
                Intrinsics.checkNotNull(navGraph2);
                navDestination = navGraph2.findNode(i2);
            }
            if (navDestination == null) {
                return NavDestination.Companion.getDisplayName(this.context, i2);
            }
            if (i != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    Intrinsics.checkNotNull(navGraph);
                    if (!(navGraph.findNode(navGraph.getStartDestinationId()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestinationId());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public final NavDestination findDestination(int i) {
        NavDestination navDestination;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph);
        if (navGraph.getId() == i) {
            return this._graph;
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            NavGraph navGraph2 = this._graph;
            Intrinsics.checkNotNull(navGraph2);
            navDestination = navGraph2;
        }
        return findDestination(navDestination, i);
    }

    private final NavDestination findDestination(NavDestination navDestination, int i) {
        NavGraph navGraph;
        if (navDestination.getId() == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNode(i);
    }

    public final NavDestination findDestination(String str) {
        NavDestination navDestination;
        NavGraph navGraph;
        Intrinsics.checkNotNullParameter(str, "destinationRoute");
        NavGraph navGraph2 = this._graph;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (Intrinsics.areEqual((Object) navGraph2.getRoute(), (Object) str)) {
            return this._graph;
        }
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            NavGraph navGraph3 = this._graph;
            Intrinsics.checkNotNull(navGraph3);
            navDestination = navGraph3;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.findNode(str);
    }

    public void navigate(int i) {
        navigate(i, (Bundle) null);
    }

    public void navigate(int i, Bundle bundle) {
        navigate(i, bundle, (NavOptions) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Navigator.Extras) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavDestination navDestination;
        int i2;
        if (getBackQueue().isEmpty()) {
            navDestination = this._graph;
        } else {
            navDestination = getBackQueue().last().getDestination();
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i2 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i2 = i;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i2 != 0 || navOptions == null || navOptions.getPopUpToId() == -1) {
                boolean z = true;
                if (i2 != 0) {
                    NavDestination findDestination = findDestination(i2);
                    if (findDestination == null) {
                        String displayName = NavDestination.Companion.getDisplayName(this.context, i2);
                        if (action != null) {
                            z = false;
                        }
                        if (!z) {
                            throw new IllegalArgumentException(("Navigation destination " + displayName + " referenced from action " + NavDestination.Companion.getDisplayName(this.context, i) + " cannot be found from the current destination " + navDestination).toString());
                        }
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + navDestination);
                    }
                    navigate(findDestination, bundle2, navOptions, extras);
                    return;
                }
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
            }
            popBackStack(navOptions.getPopUpToId(), navOptions.isPopUpToInclusive());
            return;
        }
        throw new IllegalStateException("no current navigation node");
    }

    public void navigate(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public void navigate(Uri uri, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, (Navigator.Extras) null);
    }

    public void navigate(Uri uri, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(uri, SDKConstants.PARAM_DEEP_LINK);
        navigate(new NavDeepLinkRequest(uri, (String) null, (String) null), navOptions, extras);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        NavGraph navGraph = this._graph;
        Intrinsics.checkNotNull(navGraph);
        NavDestination.DeepLinkMatch matchDeepLink = navGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            Bundle addInDefaultArgs = matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs());
            if (addInDefaultArgs == null) {
                addInDefaultArgs = new Bundle();
            }
            NavDestination destination = matchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
            intent.setAction(navDeepLinkRequest.getAction());
            addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
            navigate(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this._graph);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0123 A[LOOP:1: B:42:0x011d->B:44:0x0123, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigate(androidx.navigation.NavDestination r21, android.os.Bundle r22, androidx.navigation.NavOptions r23, androidx.navigation.Navigator.Extras r24) {
        /*
            r20 = this;
            r6 = r20
            r3 = r23
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r2)
            goto L_0x0010
        L_0x0021:
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r8 = 0
            if (r3 == 0) goto L_0x0042
            int r0 = r23.getPopUpToId()
            r1 = -1
            if (r0 == r1) goto L_0x0042
            int r0 = r23.getPopUpToId()
            boolean r1 = r23.isPopUpToInclusive()
            boolean r4 = r23.shouldPopUpToSaveState()
            boolean r0 = r6.popBackStackInternal(r0, r1, r4)
            r9 = r0
            goto L_0x0043
        L_0x0042:
            r9 = 0
        L_0x0043:
            android.os.Bundle r0 = r21.addInDefaultArgs(r22)
            if (r3 == 0) goto L_0x0051
            boolean r1 = r23.shouldRestoreState()
            if (r1 != r2) goto L_0x0051
            r1 = 1
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            if (r1 == 0) goto L_0x0072
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r6.backStackMap
            int r4 = r21.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0072
            int r1 = r21.getId()
            r4 = r24
            boolean r0 = r6.restoreStateInternal(r1, r0, r3, r4)
            r7.element = r0
            goto L_0x010d
        L_0x0072:
            r4 = r24
            androidx.navigation.NavBackStackEntry r1 = r20.getCurrentBackStackEntry()
            androidx.navigation.NavigatorProvider r5 = r6._navigatorProvider
            java.lang.String r10 = r21.getNavigatorName()
            androidx.navigation.Navigator r5 = r5.getNavigator((java.lang.String) r10)
            if (r3 == 0) goto L_0x008c
            boolean r10 = r23.shouldLaunchSingleTop()
            if (r10 != r2) goto L_0x008c
            r10 = 1
            goto L_0x008d
        L_0x008c:
            r10 = 0
        L_0x008d:
            if (r10 == 0) goto L_0x00d8
            if (r1 == 0) goto L_0x00a3
            androidx.navigation.NavDestination r10 = r1.getDestination()
            if (r10 == 0) goto L_0x00a3
            int r11 = r21.getId()
            int r10 = r10.getId()
            if (r11 != r10) goto L_0x00a3
            r10 = 1
            goto L_0x00a4
        L_0x00a3:
            r10 = 0
        L_0x00a4:
            if (r10 == 0) goto L_0x00d8
            kotlin.collections.ArrayDeque r3 = r20.getBackQueue()
            java.lang.Object r3 = r3.removeLast()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            r6.unlinkChildFromParent$navigation_runtime_release(r3)
            androidx.navigation.NavBackStackEntry r3 = new androidx.navigation.NavBackStackEntry
            r3.<init>(r1, r0)
            kotlin.collections.ArrayDeque r0 = r20.getBackQueue()
            r0.addLast(r3)
            androidx.navigation.NavDestination r0 = r3.getDestination()
            androidx.navigation.NavGraph r0 = r0.getParent()
            if (r0 == 0) goto L_0x00d4
            int r0 = r0.getId()
            androidx.navigation.NavBackStackEntry r0 = r6.getBackStackEntry((int) r0)
            r6.linkChildToParent(r3, r0)
        L_0x00d4:
            r5.onLaunchSingleTop(r3)
            goto L_0x010e
        L_0x00d8:
            androidx.navigation.NavBackStackEntry$Companion r10 = androidx.navigation.NavBackStackEntry.Companion
            android.content.Context r11 = r6.context
            androidx.lifecycle.Lifecycle$State r14 = r20.getHostLifecycleState$navigation_runtime_release()
            androidx.navigation.NavControllerViewModel r1 = r6.viewModel
            r15 = r1
            androidx.navigation.NavViewModelStoreProvider r15 = (androidx.navigation.NavViewModelStoreProvider) r15
            r16 = 0
            r17 = 0
            r18 = 96
            r19 = 0
            r12 = r21
            r13 = r0
            androidx.navigation.NavBackStackEntry r1 = androidx.navigation.NavBackStackEntry.Companion.create$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r1)
            androidx.navigation.NavController$navigate$4 r1 = new androidx.navigation.NavController$navigate$4
            r10 = r21
            r1.<init>(r7, r6, r10, r0)
            r10 = r1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0 = r20
            r1 = r5
            r3 = r23
            r4 = r24
            r5 = r10
            r0.navigateInternal(r1, r2, r3, r4, r5)
        L_0x010d:
            r2 = 0
        L_0x010e:
            r20.updateOnBackPressedCallbackEnabled()
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r0 = r6.navigatorState
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x011d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012d
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavController$NavControllerNavigatorState r1 = (androidx.navigation.NavController.NavControllerNavigatorState) r1
            r1.setNavigating(r8)
            goto L_0x011d
        L_0x012d:
            if (r9 != 0) goto L_0x013a
            boolean r0 = r7.element
            if (r0 != 0) goto L_0x013a
            if (r2 == 0) goto L_0x0136
            goto L_0x013a
        L_0x0136:
            r20.updateBackStackLifecycle$navigation_runtime_release()
            goto L_0x013d
        L_0x013a:
            r20.dispatchOnDestinationChanged()
        L_0x013d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008e, code lost:
        r5 = (r5 = (androidx.navigation.NavBackStackEntry) kotlin.collections.CollectionsKt.last(r4)).getDestination();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean restoreStateInternal(int r12, android.os.Bundle r13, androidx.navigation.NavOptions r14, androidx.navigation.Navigator.Extras r15) {
        /*
            r11 = this;
            java.util.Map<java.lang.Integer, java.lang.String> r0 = r11.backStackMap
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            boolean r0 = r0.containsKey(r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.Map<java.lang.Integer, java.lang.String> r0 = r11.backStackMap
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r12 = r0.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            java.util.Map<java.lang.Integer, java.lang.String> r0 = r11.backStackMap
            java.util.Collection r0 = r0.values()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            androidx.navigation.NavController$restoreStateInternal$1 r2 = new androidx.navigation.NavController$restoreStateInternal$1
            r2.<init>(r12)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.collections.CollectionsKt.removeAll(r0, r2)
            java.util.Map<java.lang.String, kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntryState>> r0 = r11.backStackStates
            java.util.Map r0 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r0)
            java.lang.Object r12 = r0.remove(r12)
            kotlin.collections.ArrayDeque r12 = (kotlin.collections.ArrayDeque) r12
            java.util.List r12 = r11.instantiateBackStack(r12)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r2 = r12
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0051:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r2.next()
            r5 = r4
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
            androidx.navigation.NavDestination r5 = r5.getDestination()
            boolean r5 = r5 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x0051
            r3.add(r4)
            goto L_0x0051
        L_0x006a:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r2 = r3.iterator()
        L_0x0072:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00be
            java.lang.Object r3 = r2.next()
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            java.lang.Object r4 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x0099
            java.lang.Object r5 = kotlin.collections.CollectionsKt.last(r4)
            androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
            if (r5 == 0) goto L_0x0099
            androidx.navigation.NavDestination r5 = r5.getDestination()
            if (r5 == 0) goto L_0x0099
            java.lang.String r5 = r5.getNavigatorName()
            goto L_0x009a
        L_0x0099:
            r5 = 0
        L_0x009a:
            androidx.navigation.NavDestination r6 = r3.getDestination()
            java.lang.String r6 = r6.getNavigatorName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00ae
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r3)
            goto L_0x0072
        L_0x00ae:
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = 1
            androidx.navigation.NavBackStackEntry[] r5 = new androidx.navigation.NavBackStackEntry[r5]
            r5[r1] = r3
            java.util.List r3 = kotlin.collections.CollectionsKt.mutableListOf(r5)
            r4.add(r3)
            goto L_0x0072
        L_0x00be:
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00c7:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0104
            java.lang.Object r2 = r0.next()
            r8 = r2
            java.util.List r8 = (java.util.List) r8
            androidx.navigation.NavigatorProvider r2 = r11._navigatorProvider
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r8)
            androidx.navigation.NavBackStackEntry r3 = (androidx.navigation.NavBackStackEntry) r3
            androidx.navigation.NavDestination r3 = r3.getDestination()
            java.lang.String r3 = r3.getNavigatorName()
            androidx.navigation.Navigator r9 = r2.getNavigator((java.lang.String) r3)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            androidx.navigation.NavController$restoreStateInternal$4 r10 = new androidx.navigation.NavController$restoreStateInternal$4
            r2 = r10
            r3 = r1
            r4 = r12
            r6 = r11
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r10
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = r11
            r4 = r9
            r5 = r8
            r6 = r14
            r7 = r15
            r8 = r2
            r3.navigateInternal(r4, r5, r6, r7, r8)
            goto L_0x00c7
        L_0x0104:
            boolean r12 = r1.element
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.restoreStateInternal(int, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):boolean");
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavDestination navDestination;
        List<NavBackStackEntry> arrayList = new ArrayList<>();
        NavBackStackEntry lastOrNull = getBackQueue().lastOrNull();
        if (lastOrNull == null || (navDestination = lastOrNull.getDestination()) == null) {
            navDestination = getGraph();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination findDestination = findDestination(navDestination, navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.context, findDestination, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
                    navDestination = findDestination;
                } else {
                    String displayName = NavDestination.Companion.getDisplayName(this.context, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException(("Restore State failed: destination " + displayName + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void addEntryToBackStack$default(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                list = CollectionsKt.emptyList();
            }
            navController.addEntryToBackStack(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    /* access modifiers changed from: private */
    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        NavDestination navDestination2;
        Bundle bundle2;
        List<NavBackStackEntry> list2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        NavBackStackEntry navBackStackEntry2;
        NavDestination navDestination3;
        NavBackStackEntry navBackStackEntry3;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntry4;
        Bundle bundle3;
        List<NavBackStackEntry> list3;
        NavDestination navDestination4 = navDestination;
        Bundle bundle4 = bundle;
        NavBackStackEntry navBackStackEntry5 = navBackStackEntry;
        List<NavBackStackEntry> list4 = list;
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof FloatingWindow)) {
            while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof FloatingWindow)) {
                if (!popBackStackInternal$default(this, getBackQueue().last().getDestination().getId(), true, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NavBackStackEntry navBackStackEntry6 = null;
        if (navDestination4 instanceof NavGraph) {
            NavDestination navDestination5 = destination;
            while (true) {
                Intrinsics.checkNotNull(navDestination5);
                NavGraph parent = navDestination5.getParent();
                if (parent != null) {
                    ListIterator<NavBackStackEntry> listIterator = list4.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntry4 = null;
                            break;
                        }
                        navBackStackEntry4 = listIterator.previous();
                        if (Intrinsics.areEqual((Object) navBackStackEntry4.getDestination(), (Object) parent)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry7 = navBackStackEntry4;
                    if (navBackStackEntry7 == null) {
                        navDestination2 = destination;
                        list3 = list4;
                        bundle3 = bundle4;
                        navBackStackEntry2 = navBackStackEntry5;
                        navBackStackEntry7 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, parent, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                    } else {
                        navDestination2 = destination;
                        list3 = list4;
                        navBackStackEntry2 = navBackStackEntry5;
                        bundle3 = bundle4;
                    }
                    arrayDeque2.addFirst(navBackStackEntry7);
                    if (!(!getBackQueue().isEmpty()) || getBackQueue().last().getDestination() != parent) {
                        list2 = list3;
                        bundle2 = bundle3;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                    } else {
                        list2 = list3;
                        bundle2 = bundle3;
                        navGraph = parent;
                        arrayDeque = arrayDeque2;
                        popEntryFromBackStack$default(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
                    }
                } else {
                    navGraph = parent;
                    arrayDeque = arrayDeque2;
                    navDestination2 = destination;
                    list2 = list4;
                    navBackStackEntry2 = navBackStackEntry5;
                    bundle2 = bundle4;
                }
                navDestination5 = navGraph;
                if (navDestination5 == null || navDestination5 == navDestination4) {
                    break;
                }
                navBackStackEntry5 = navBackStackEntry2;
                arrayDeque2 = arrayDeque;
                bundle4 = bundle2;
                list4 = list2;
                destination = navDestination2;
            }
        } else {
            arrayDeque = arrayDeque2;
            navDestination2 = destination;
            list2 = list4;
            navBackStackEntry2 = navBackStackEntry5;
            bundle2 = bundle4;
        }
        NavDestination destination2 = arrayDeque.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque.first()).getDestination();
        while (destination2 != null && findDestination(destination2.getId()) == null) {
            NavGraph parent2 = destination2.getParent();
            if (parent2 != null) {
                ListIterator<NavBackStackEntry> listIterator2 = list2.listIterator(list.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntry3 = null;
                        break;
                    }
                    navBackStackEntry3 = listIterator2.previous();
                    if (Intrinsics.areEqual((Object) navBackStackEntry3.getDestination(), (Object) parent2)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry8 = navBackStackEntry3;
                if (navBackStackEntry8 == null) {
                    navBackStackEntry8 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, parent2, parent2.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
                }
                arrayDeque.addFirst(navBackStackEntry8);
            }
            destination2 = parent2;
        }
        if (!arrayDeque.isEmpty()) {
            navDestination2 = ((NavBackStackEntry) arrayDeque.last()).getDestination();
        }
        while (!getBackQueue().isEmpty() && (getBackQueue().last().getDestination() instanceof NavGraph) && ((NavGraph) getBackQueue().last().getDestination()).findNode(navDestination2.getId(), false) == null) {
            popEntryFromBackStack$default(this, getBackQueue().last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry firstOrNull = getBackQueue().firstOrNull();
        if (firstOrNull == null) {
            firstOrNull = (NavBackStackEntry) arrayDeque.firstOrNull();
        }
        if (firstOrNull != null) {
            navDestination3 = firstOrNull.getDestination();
        } else {
            navDestination3 = null;
        }
        if (!Intrinsics.areEqual((Object) navDestination3, (Object) this._graph)) {
            ListIterator<NavBackStackEntry> listIterator3 = list2.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator3.previous();
                NavDestination destination3 = previous.getDestination();
                NavGraph navGraph2 = this._graph;
                Intrinsics.checkNotNull(navGraph2);
                if (Intrinsics.areEqual((Object) destination3, (Object) navGraph2)) {
                    navBackStackEntry6 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry9 = navBackStackEntry6;
            if (navBackStackEntry9 == null) {
                NavBackStackEntry.Companion companion = NavBackStackEntry.Companion;
                Context context2 = this.context;
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                NavGraph navGraph4 = this._graph;
                Intrinsics.checkNotNull(navGraph4);
                navBackStackEntry9 = NavBackStackEntry.Companion.create$default(companion, context2, navGraph3, navGraph4.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel, (String) null, (Bundle) null, 96, (Object) null);
            }
            arrayDeque.addFirst(navBackStackEntry9);
        }
        for (NavBackStackEntry navBackStackEntry10 : arrayDeque) {
            NavControllerNavigatorState navControllerNavigatorState = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry10.getDestination().getNavigatorName()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.addInternal(navBackStackEntry10);
            } else {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.getNavigatorName() + " should already be created").toString());
            }
        }
        Collection collection = arrayDeque;
        getBackQueue().addAll(collection);
        getBackQueue().add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry11 : CollectionsKt.plus(collection, navBackStackEntry2)) {
            NavGraph parent3 = navBackStackEntry11.getDestination().getParent();
            if (parent3 != null) {
                linkChildToParent(navBackStackEntry11, getBackStackEntry(parent3.getId()));
            }
        }
    }

    public void navigate(NavDirections navDirections) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null);
    }

    public void navigate(NavDirections navDirections, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(NavDirections navDirections, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(navDirections, "directions");
        Intrinsics.checkNotNullParameter(extras, "navigatorExtras");
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    public final void navigate(String str, Function1<? super NavOptionsBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "route");
        Intrinsics.checkNotNullParameter(function1, "builder");
        navigate$default(this, str, NavOptionsBuilderKt.navOptions(function1), (Navigator.Extras) null, 4, (Object) null);
    }

    public static /* synthetic */ void navigate$default(NavController navController, String str, NavOptions navOptions, Navigator.Extras extras, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                navOptions = null;
            }
            if ((i & 4) != 0) {
                extras = null;
            }
            navController.navigate(str, navOptions, extras);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    public final void navigate(String str, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(str, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.Companion;
        Uri parse = Uri.parse(NavDestination.Companion.createRoute(str));
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        navigate(companion.fromUri(parse).build(), navOptions, extras);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this._navigatorProvider.getNavigators().entrySet()) {
            String str = (String) next.getKey();
            Bundle onSaveState = ((Navigator) next.getValue()).onSaveState();
            if (onSaveState != null) {
                arrayList.add(str);
                bundle2.putBundle(str, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!getBackQueue().isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[getBackQueue().size()];
            Iterator it = getBackQueue().iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                i++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (!this.backStackMap.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.backStackMap.size()];
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (Map.Entry next2 : this.backStackMap.entrySet()) {
                int i3 = i2 + 1;
                iArr[i2] = ((Number) next2.getKey()).intValue();
                arrayList2.add((String) next2.getValue());
                i2 = i3;
            }
            bundle.putIntArray(KEY_BACK_STACK_DEST_IDS, iArr);
            bundle.putStringArrayList(KEY_BACK_STACK_IDS, arrayList2);
        }
        if (!this.backStackStates.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry next3 : this.backStackStates.entrySet()) {
                String str2 = (String) next3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) next3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i4 = 0;
                for (Object next4 : arrayDeque) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i4] = (NavBackStackEntryState) next4;
                    i4 = i5;
                }
                bundle.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str2, parcelableArr2);
            }
            bundle.putStringArrayList(KEY_BACK_STACK_STATES_IDS, arrayList3);
        }
        if (this.deepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
        }
        return bundle;
    }

    public void restoreState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.context.getClassLoader());
            this.navigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
            this.backStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
            this.backStackStates.clear();
            int[] intArray = bundle.getIntArray(KEY_BACK_STACK_DEST_IDS);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_BACK_STACK_IDS);
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    this.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i2));
                    i++;
                    i2++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + str);
                    if (parcelableArray != null) {
                        Map<String, ArrayDeque<NavBackStackEntryState>> map = this.backStackStates;
                        Intrinsics.checkNotNullExpressionValue(str, "id");
                        ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                        Iterator it = ArrayIteratorKt.iterator(parcelableArray);
                        while (it.hasNext()) {
                            Parcelable parcelable = (Parcelable) it.next();
                            if (parcelable != null) {
                                arrayDeque.add((NavBackStackEntryState) parcelable);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                            }
                        }
                        map.put(str, arrayDeque);
                    }
                }
            }
            this.deepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "owner");
        if (!Intrinsics.areEqual((Object) lifecycleOwner2, (Object) this.lifecycleOwner)) {
            LifecycleOwner lifecycleOwner3 = this.lifecycleOwner;
            if (!(lifecycleOwner3 == null || (lifecycle = lifecycleOwner3.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.lifecycleObserver);
            }
            this.lifecycleOwner = lifecycleOwner2;
            lifecycleOwner2.getLifecycle().addObserver(this.lifecycleObserver);
        }
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher onBackPressedDispatcher2) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher2, "dispatcher");
        if (!Intrinsics.areEqual((Object) onBackPressedDispatcher2, (Object) this.onBackPressedDispatcher)) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (lifecycleOwner2 != null) {
                this.onBackPressedCallback.remove();
                this.onBackPressedDispatcher = onBackPressedDispatcher2;
                onBackPressedDispatcher2.addCallback(lifecycleOwner2, this.onBackPressedCallback);
                Lifecycle lifecycle = lifecycleOwner2.getLifecycle();
                lifecycle.removeObserver(this.lifecycleObserver);
                lifecycle.addObserver(this.lifecycleObserver);
                return;
            }
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
    }

    public void enableOnBackPressed(boolean z) {
        this.enableOnBackPressedCallback = z;
        updateOnBackPressedCallbackEnabled();
    }

    private final void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        boolean z = true;
        if (!this.enableOnBackPressedCallback || getDestinationCountOnBackStack() <= 1) {
            z = false;
        }
        onBackPressedCallback2.setEnabled(z);
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
        if (!Intrinsics.areEqual((Object) this.viewModel, (Object) NavControllerViewModel.Companion.getInstance(viewModelStore))) {
            if (getBackQueue().isEmpty()) {
                this.viewModel = NavControllerViewModel.Companion.getInstance(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int i) {
        if (this.viewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException(("No NavGraph with ID " + i + " is on the NavController's back stack").toString());
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
    }

    public NavBackStackEntry getBackStackEntry(int i) {
        Object obj;
        boolean z;
        List backQueue2 = getBackQueue();
        ListIterator listIterator = backQueue2.listIterator(backQueue2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).getDestination().getId() == i) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with ID " + i + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public final NavBackStackEntry getBackStackEntry(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "route");
        List backQueue2 = getBackQueue();
        ListIterator listIterator = backQueue2.listIterator(backQueue2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).getDestination().getRoute(), (Object) str)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return getBackQueue().lastOrNull();
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Object obj;
        Iterator it = CollectionsKt.reversed(getBackQueue()).iterator();
        if (it.hasNext()) {
            it.next();
        }
        Iterator it2 = SequencesKt.asSequence(it).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (!(((NavBackStackEntry) obj).getDestination() instanceof NavGraph)) {
                break;
            }
        }
        return (NavBackStackEntry) obj;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0010\u0010\f\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "()V", "KEY_BACK_STACK", "", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NavController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean z) {
            NavController.deepLinkSaveState = z;
        }
    }
}
