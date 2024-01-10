package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000Ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b7\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b)\b\u0000\u0018\u00002\u00020\u0001:\u0004ä\u0002å\u0002Bí\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012Y\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020\u0014H\u0002JK\u0010\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u0001\"\u0005\b\u0001\u0010\u00012\b\u0010\u0001\u001a\u0003H\u00012\"\u0010\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u0001\u0012\u0004\u0012\u00020\u00140\u0001¢\u0006\u0003\b\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0005H\u0016J5\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020!2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010 \u0001H\bø\u0001\u0000¢\u0006\u0003\u0010¡\u0001J\u0014\u0010¢\u0001\u001a\u00020!2\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0017J\u0012\u0010¢\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020!H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030£\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¤\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¥\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¦\u0001H\u0017J\u0012\u0010¢\u0001\u001a\u00020!2\u0007\u0010\u0001\u001a\u00020%H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030§\u0001H\u0017J\u0013\u0010¢\u0001\u001a\u00020!2\b\u0010\u0001\u001a\u00030¨\u0001H\u0017J\u000f\u0010©\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bª\u0001J\t\u0010«\u0001\u001a\u00020\u0014H\u0002J\t\u0010¬\u0001\u001a\u00020\u0014H\u0002J\t\u0010­\u0001\u001a\u00020\u0014H\u0016JG\u0010®\u0001\u001a\u00020\u00142\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u00012\u0014\u0010²\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140 \u0001¢\u0006\u0003\b³\u0001H\u0000¢\u0006\u0006\b´\u0001\u0010µ\u0001J$\u0010¶\u0001\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010¸\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020%H\u0002J'\u0010º\u0001\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010»\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010lH\u0017¢\u0006\u0003\u0010¼\u0001J\t\u0010½\u0001\u001a\u00020\u0014H\u0002J!\u0010¾\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010 \u0001H\u0016J<\u0010À\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0003\u0010Á\u0001J\u0012\u0010Â\u0001\u001a\u00020\u00142\u0007\u0010¢\u0001\u001a\u00020!H\u0017J\t\u0010Ã\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010Ä\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÅ\u0001JF\u0010Æ\u0001\u001a\u00020\u00142\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u00012\u0016\u0010²\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010 \u0001¢\u0006\u0003\b³\u0001H\u0002¢\u0006\u0003\u0010µ\u0001J\u001b\u0010Ç\u0001\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010È\u0001\u001a\u00020%H\u0002J\t\u0010É\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010Ê\u0001\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!H\u0002J\t\u0010Ì\u0001\u001a\u00020\u0014H\u0017J\t\u0010Í\u0001\u001a\u00020\u0014H\u0002J\t\u0010Î\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ï\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ð\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ñ\u0001\u001a\u00020\u0014H\u0017J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\t\u0010Ô\u0001\u001a\u00020\u0014H\u0016J\t\u0010Õ\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010×\u0001\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010pH\u0002J\u001a\u0010Ù\u0001\u001a\u00020\u00142\u0007\u0010Ú\u0001\u001a\u00020%2\u0006\u0010X\u001a\u00020!H\u0002J\t\u0010Û\u0001\u001a\u00020\u0014H\u0002J\u000e\u0010F\u001a\u00020!H\u0000¢\u0006\u0003\bÜ\u0001J\"\u0010Ý\u0001\u001a\u00020\u00142\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030Þ\u00012\t\u0010ß\u0001\u001a\u0004\u0018\u00010CH\u0017J*\u0010à\u0001\u001a\u00020\u00142\u001f\u0010á\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ä\u0001\u0012\u0007\u0012\u0005\u0018\u00010ä\u00010ã\u00010â\u0001H\u0002J*\u0010å\u0001\u001a\u00020\u00142\u001f\u0010á\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030ä\u0001\u0012\u0007\u0012\u0005\u0018\u00010ä\u00010ã\u00010â\u0001H\u0017J\u0012\u0010æ\u0001\u001a\u00020%2\u0007\u0010ç\u0001\u001a\u00020%H\u0002JX\u0010è\u0001\u001a\u00020\u00142\u0010\u0010²\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010C0Þ\u00012'\u0010é\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2\t\u0010ß\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010ê\u0001\u001a\u00020!H\u0002J\u001f\u0010ë\u0001\u001a\u00020C2\t\u0010ì\u0001\u001a\u0004\u0018\u00010C2\t\u0010í\u0001\u001a\u0004\u0018\u00010CH\u0017J\u000b\u0010î\u0001\u001a\u0004\u0018\u00010CH\u0001J-\u0010ï\u0001\u001a\u00020%2\u0007\u0010ð\u0001\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010¸\u0001\u001a\u00020%2\u0007\u0010ñ\u0001\u001a\u00020%H\u0002J\u000f\u0010ò\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bó\u0001J\u001f\u0010ô\u0001\u001a\u00020\u00142\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140 \u0001H\u0000¢\u0006\u0003\bõ\u0001J\t\u0010ö\u0001\u001a\u00020\u0014H\u0002J!\u0010ö\u0001\u001a\u00020\u00142\u0010\u0010÷\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010C0ø\u0001H\u0002¢\u0006\u0003\u0010ù\u0001J\t\u0010ú\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010û\u0001\u001a\u00020\u00142\t\b\u0002\u0010ü\u0001\u001a\u00020!H\u0002J\t\u0010ý\u0001\u001a\u00020\u0014H\u0002J.\u0010þ\u0001\u001a\u00020!2\u001d\u0010¯\u0001\u001a\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010°\u0001H\u0000¢\u0006\u0003\bÿ\u0001Jv\u0010\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010ç\u0001\u001a\u0004\u0018\u00010%2%\b\u0002\u0010\\\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u000206\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020C\u0018\u00010±\u00010ã\u00010â\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\u0002¢\u0006\u0003\u0010\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020PH\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001a\u0010\u0002\u001a\u00020\u00142\u0006\u0010h\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0019\u0010\u0002\u001a\u00020\u00142\u000e\u0010\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140 \u0001H\u0016J\t\u0010\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0002\u001a\u00020\u00142T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010\u0002\u001a\u00020\u00142\t\b\u0002\u0010ü\u0001\u001a\u00020!2T\u0010\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0002\u001a\u00020\u0014H\u0002J$\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u0012\u0010 \u0002\u001a\u00020\u00142\u0007\u0010¡\u0002\u001a\u00020~H\u0016J\t\u0010¢\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010£\u0002\u001a\u00020\u00142\b\u0010¤\u0002\u001a\u00030ä\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000b\u0010¥\u0002\u001a\u0004\u0018\u00010CH\u0016J\t\u0010¦\u0002\u001a\u00020\u0014H\u0002J\u0012\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020%H\u0002JP\u0010©\u0002\u001a\u0003H\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010»\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010l2'\u0010¡\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nH\u0002¢\u0006\u0003\u0010ª\u0002J\t\u0010«\u0002\u001a\u00020\u0014H\u0017J\t\u0010¬\u0002\u001a\u00020\u0014H\u0002J\t\u0010­\u0002\u001a\u00020\u0014H\u0002J\t\u0010®\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010¯\u0002\u001a\u00020\u00142\b\u0010¯\u0002\u001a\u00030°\u0002H\u0017J\t\u0010±\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010²\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\b\u0010¯\u0002\u001a\u00030°\u0002H\u0017J1\u0010³\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010´\u0002\u001a\u0004\u0018\u00010C2\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\t\u0010¶\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010·\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%H\u0002J\u001d\u0010·\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0002J\u001d\u0010¹\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0017J\t\u0010º\u0002\u001a\u00020\u0014H\u0016J&\u0010»\u0002\u001a\u00020\u00142\u0015\u0010¼\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030½\u00020ø\u0001H\u0017¢\u0006\u0003\u0010¾\u0002J\u001d\u0010¿\u0002\u001a\u00020\u00142\u0007\u0010Ë\u0001\u001a\u00020!2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010À\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%H\u0017J\u0012\u0010Á\u0002\u001a\u00020\u00012\u0007\u0010»\u0001\u001a\u00020%H\u0017J\u001d\u0010Â\u0002\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010CH\u0016J\t\u0010Ã\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ä\u0002\u001a\u00020\u0014H\u0002J#\u0010Å\u0002\u001a\u00020!2\u0007\u0010¡\u0002\u001a\u0002062\t\u0010Æ\u0002\u001a\u0004\u0018\u00010CH\u0000¢\u0006\u0003\bÇ\u0002J\u0014\u0010È\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0001J(\u0010É\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010C2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010Ë\u0002\u001a\u00020\u00142\u0007\u0010Ì\u0002\u001a\u00020%H\u0002J(\u0010Í\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%2\t\u0010¸\u0002\u001a\u0004\u0018\u00010C2\t\u0010µ\u0002\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010Î\u0002\u001a\u00020\u00142\u0007\u0010Ê\u0002\u001a\u00020%H\u0002J\u001b\u0010Ï\u0002\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020%H\u0002J\u001b\u0010Ð\u0002\u001a\u00020\u00142\u0007\u0010·\u0001\u001a\u00020%2\u0007\u0010Ñ\u0002\u001a\u00020%H\u0002J{\u0010Ò\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2'\u0010Ó\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n2'\u0010Ô\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nH\u0002J\u0014\u0010Õ\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0016J\u0014\u0010Ö\u0002\u001a\u00020\u00142\t\u0010\u0001\u001a\u0004\u0018\u00010CH\u0001J\u0012\u0010×\u0002\u001a\u00020%2\u0007\u0010·\u0001\u001a\u00020%H\u0002J\t\u0010Ø\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ù\u0002\u001a\u00020\u0014H\u0002J\t\u0010Ú\u0002\u001a\u00020\u0014H\u0002J\u000f\u0010Û\u0002\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÜ\u0002J\u0001\u0010Ý\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022Z\u0010Þ\u0002\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\b¢\u0006\u0003\u0010ß\u0002J1\u0010à\u0002\u001a\u0003H\u0002\"\u0005\b\u0000\u0010\u00022\u0006\u0010{\u001a\u00020|2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00020 \u0001H\b¢\u0006\u0003\u0010á\u0002J\u0016\u0010â\u0002\u001a\u00020%*\u00020|2\u0007\u0010·\u0001\u001a\u00020%H\u0002J\u0018\u0010ã\u0002\u001a\u0004\u0018\u00010C*\u00020|2\u0007\u0010ç\u0001\u001a\u00020%H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R&\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020%8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010'R\u0016\u00105\u001a\u0004\u0018\u0001068@X\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020!8VX\u0004¢\u0006\f\u0012\u0004\b:\u00103\u001a\u0004\b;\u0010#Ro\u0010<\u001aW\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bK\u0010#R\u0014\u0010L\u001a\u00020!8@X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010#R\u000e\u0010N\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u000e¢\u0006\u0002\n\u0000Ra\u0010Q\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VRa\u0010W\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150BX\u0004¢\u0006\u0002\n\u0000R&\u0010X\u001a\u00020!2\u0006\u00100\u001a\u00020!8\u0016@RX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bY\u00103\u001a\u0004\bZ\u0010#R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u0002060BX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010^\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010#R\u001e\u0010`\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010#Ra\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R.\u0010d\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010ej\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R.\u0010j\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R2\u0010w\u001a&\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m\u0018\u00010kj\u0004\u0018\u0001`nX\u000e¢\u0006\u0002\n\u0000Rj\u0010x\u001a^\u0012\u0004\u0012\u00020%\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n0ej.\u0012\u0004\u0012\u00020%\u0012$\u0012\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0l\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010C0m0kj\u0002`n`fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010}\u001a\u0004\u0018\u00010~8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010C8VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020!8VX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u00103\u001a\u0005\b\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020EX\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u0004\u0018\u00010C*\u00020|8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006æ\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Ljava/util/List;", "setDeferredChanges$runtime_release", "(Ljava/util/List;)V", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerCache", "providerUpdates", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "startedGroup", "startedGroups", "writer", "writerHasAProvider", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "(Ljava/lang/Integer;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "deactivateToEndGroup", "disableReusing", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "releaseMovableGroupAtCurrent", "reference", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resolveCompositionLocal", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)Ljava/lang/Object;", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "data", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withChanges", "newChanges", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Composer.kt */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    /* access modifiers changed from: private */
    public List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    /* access modifiers changed from: private */
    public int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges;
    private Stack<Object> downNodes;
    private final IntStack entersStack = new IntStack();
    private boolean forceRecomposeScopes;
    /* access modifiers changed from: private */
    public boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack = new IntStack();
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    private SlotTable insertTable;
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack = new Stack<>();
    private final List<Invalidation> invalidations = new ArrayList();
    private boolean isComposing;
    private boolean isDisposed;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    /* access modifiers changed from: private */
    public int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack = new IntStack();
    /* access modifiers changed from: private */
    public final CompositionContext parentContext;
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> parentProvider = ExtensionsKt.persistentHashMapOf();
    private Pending pending;
    private final Stack<Pending> pendingStack = new Stack<>();
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> providerCache;
    private final HashMap<Integer, PersistentMap<CompositionLocal<Object>, State<Object>>> providerUpdates = new HashMap<>();
    private boolean providersInvalid;
    private final IntStack providersInvalidStack = new IntStack();
    /* access modifiers changed from: private */
    public SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    /* access modifiers changed from: private */
    public final SlotTable slotTable;
    private Snapshot snapshot = SnapshotKt.currentSnapshot();
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int i) {
        return -2 - i;
    }

    /* JADX INFO: finally extract failed */
    public ComposerImpl(Applier<?> applier2, CompositionContext compositionContext, SlotTable slotTable2, Set<RememberObserver> set, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list2, ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(applier2, "applier");
        Intrinsics.checkNotNullParameter(compositionContext, "parentContext");
        Intrinsics.checkNotNullParameter(slotTable2, "slotTable");
        Intrinsics.checkNotNullParameter(set, "abandonSet");
        Intrinsics.checkNotNullParameter(list, "changes");
        Intrinsics.checkNotNullParameter(list2, "lateChanges");
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        this.applier = applier2;
        this.parentContext = compositionContext;
        this.slotTable = slotTable2;
        this.abandonSet = set;
        this.changes = list;
        this.lateChanges = list2;
        this.composition = controlledComposition;
        SlotReader openReader = this.slotTable.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable3 = new SlotTable();
        this.insertTable = slotTable3;
        SlotWriter openWriter = slotTable3.openWriter();
        openWriter.close();
        this.writer = openWriter;
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    public Applier<?> getApplier() {
        return this.applier;
    }

    public ControlledComposition getComposition() {
        return this.composition;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable2) {
        Intrinsics.checkNotNullParameter(slotTable2, "<set-?>");
        this.insertTable = slotTable2;
    }

    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final void setDeferredChanges$runtime_release(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        this.deferredChanges = list;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext$runtime_release();
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        start(i, (Object) null, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void startDefaults() {
        start(-127, (Object) null, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            currentRecomposeScope$runtime_release.setDefaultsInScope(true);
        }
    }

    public boolean getDefaultsInvalid() {
        if (!this.providersInvalid) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
        }
    }

    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        start(i, obj, false, (Object) null);
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed((Object) this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set set = (Set) resolveCompositionLocal(InspectionTablesKt.getLocalInspectionTables(), this.parentProvider);
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
    }

    public final void changesApplied$runtime_release() {
        this.providerUpdates.clear();
    }

    public boolean getInserting() {
        return this.inserting;
    }

    public boolean getSkipping() {
        if (!getInserting() && !this.reusing && !this.providersInvalid) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (!(currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) || this.forciblyRecompose) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    private final void startGroup(int i) {
        start(i, (Object) null, false, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void startGroup(int i, Object obj) {
        start(i, obj, false, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    public void startNode() {
        int i = 126;
        if (getInserting() || (!this.reusing ? this.reader.getGroupKey() != 126 : this.reader.getGroupKey() != 125)) {
            i = 125;
        }
        start(i, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    public void startReusableNode() {
        start(125, (Object) null, true, (Object) null);
        this.nodeExpected = true;
    }

    public <T> void createNode(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        validateNodeExpected();
        if (getInserting()) {
            int peek = this.nodeIndexStack.peek();
            SlotWriter slotWriter = this.writer;
            Anchor anchor = slotWriter.anchor(slotWriter.getParent());
            this.groupNodeCount++;
            recordFixup(new ComposerImpl$createNode$2(function0, anchor, peek));
            recordInsertUpFixup(new ComposerImpl$createNode$3(anchor, peek));
            return;
        }
        ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public void useNode() {
        validateNodeExpected();
        if (!getInserting()) {
            recordDown(getNode(this.reader));
        } else {
            ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
            throw new KotlinNothingValueException();
        }
    }

    public void endNode() {
        end(true);
    }

    public void startReusableGroup(int i, Object obj) {
        if (this.reader.getGroupKey() == i && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        start(i, (Object) null, false, obj);
    }

    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    public <V, T> void apply(V v, Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Function3 composerImpl$apply$operation$1 = new ComposerImpl$apply$operation$1(function2, v);
        if (getInserting()) {
            recordFixup(composerImpl$apply$operation$1);
        } else {
            recordApplierOperation(composerImpl$apply$operation$1);
        }
    }

    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object access$getKey = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return access$getKey == null ? new JoinedKey(obj, obj2) : access$getKey;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }
        return this.reusing ? Composer.Companion.getEmpty() : this.reader.next();
    }

    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(char c) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Character) && c == ((Character) nextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Byte) && b == ((Number) nextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(short s) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Short) && s == ((Number) nextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(float f) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Float) {
            if (f == ((Number) nextSlot).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(double d) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Double) {
            if (d == ((Number) nextSlot).doubleValue()) {
                return false;
            }
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @ComposeCompilerApi
    public boolean changed(int i) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && i == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        T nextSlot = nextSlot();
        if (nextSlot != Composer.Companion.getEmpty() && !z) {
            return nextSlot;
        }
        T invoke = function0.invoke();
        updateValue(invoke);
        return invoke;
    }

    public final void updateValue(Object obj) {
        if (getInserting()) {
            this.writer.update(obj);
            if (obj instanceof RememberObserver) {
                record(new ComposerImpl$updateValue$1(obj));
                this.abandonSet.add(obj);
                return;
            }
            return;
        }
        int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
        if (obj instanceof RememberObserver) {
            this.abandonSet.add(obj);
        }
        recordSlotTableOperation(true, new ComposerImpl$updateValue$2(obj, groupSlotIndex));
    }

    public final void updateCachedValue(Object obj) {
        updateValue(obj);
    }

    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    public void recordSideEffect(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "effect");
        record(new ComposerImpl$recordSideEffect$1(function0));
    }

    static /* synthetic */ PersistentMap currentCompositionLocalScope$default(ComposerImpl composerImpl, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return composerImpl.currentCompositionLocalScope(num);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, androidx.compose.runtime.State<java.lang.Object>> currentCompositionLocalScope(java.lang.Integer r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0007
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>> r0 = r5.providerCache
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            boolean r0 = r5.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }"
            r2 = 202(0xca, float:2.83E-43)
            if (r0 == 0) goto L_0x004a
            boolean r0 = r5.writerHasAProvider
            if (r0 == 0) goto L_0x004a
            androidx.compose.runtime.SlotWriter r0 = r5.writer
            int r0 = r0.getParent()
        L_0x001b:
            if (r0 <= 0) goto L_0x004a
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r3 = r3.groupKey(r0)
            if (r3 != r2) goto L_0x0043
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            java.lang.Object r3 = r3.groupObjectKey(r0)
            java.lang.Object r4 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0043
            androidx.compose.runtime.SlotWriter r6 = r5.writer
            java.lang.Object r6 = r6.groupAux(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r6 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r6
            r5.providerCache = r6
            return r6
        L_0x0043:
            androidx.compose.runtime.SlotWriter r3 = r5.writer
            int r0 = r3.parent((int) r0)
            goto L_0x001b
        L_0x004a:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x009d
            if (r6 == 0) goto L_0x0059
            int r6 = r6.intValue()
            goto L_0x005f
        L_0x0059:
            androidx.compose.runtime.SlotReader r6 = r5.reader
            int r6 = r6.getParent()
        L_0x005f:
            if (r6 <= 0) goto L_0x009d
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r0 = r0.groupKey((int) r6)
            if (r0 != r2) goto L_0x0096
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r0 = r0.groupObjectKey(r6)
            java.lang.Object r3 = androidx.compose.runtime.ComposerKt.getCompositionLocalMap()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0096
            java.util.HashMap<java.lang.Integer, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, androidx.compose.runtime.State<java.lang.Object>>> r0 = r5.providerUpdates
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.get(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r0
            if (r0 != 0) goto L_0x0093
            androidx.compose.runtime.SlotReader r0 = r5.reader
            java.lang.Object r6 = r0.groupAux(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r0 = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r0
        L_0x0093:
            r5.providerCache = r0
            return r0
        L_0x0096:
            androidx.compose.runtime.SlotReader r0 = r5.reader
            int r6 = r0.parent(r6)
            goto L_0x005f
        L_0x009d:
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<java.lang.Object>, ? extends androidx.compose.runtime.State<? extends java.lang.Object>> r6 = r5.parentProvider
            r5.providerCache = r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.currentCompositionLocalScope(java.lang.Integer):androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap");
    }

    @InternalComposeApi
    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap;
        boolean z;
        Intrinsics.checkNotNullParameter(providedValueArr, "values");
        PersistentMap currentCompositionLocalScope$default = currentCompositionLocalScope$default(this, (Integer) null, 1, (Object) null);
        startGroup(201, ComposerKt.getProvider());
        startGroup(203, ComposerKt.getProviderValues());
        PersistentMap persistentMap2 = (PersistentMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(providedValueArr, currentCompositionLocalScope$default));
        endGroup();
        if (getInserting()) {
            persistentMap = updateProviderMapGroup(currentCompositionLocalScope$default, persistentMap2);
            this.writerHasAProvider = true;
        } else {
            Object groupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap<CompositionLocal<Object>, State<Object>> persistentMap3 = (PersistentMap) groupGet;
            Object groupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>{ androidx.compose.runtime.ComposerKt.CompositionLocalMap }");
            PersistentMap persistentMap4 = (PersistentMap) groupGet2;
            if (!getSkipping() || !Intrinsics.areEqual((Object) persistentMap4, (Object) persistentMap2)) {
                persistentMap = updateProviderMapGroup(currentCompositionLocalScope$default, persistentMap2);
                z = !Intrinsics.areEqual((Object) persistentMap, (Object) persistentMap3);
                if (z && !getInserting()) {
                    this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
                }
                this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
                this.providersInvalid = z;
                this.providerCache = persistentMap;
                start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
            }
            skipGroup();
            persistentMap = persistentMap3;
        }
        z = false;
        this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap);
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z;
        this.providerCache = persistentMap;
        start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap);
    }

    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @InternalComposeApi
    public <T> T consume(CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(compositionLocal, SDKConstants.PARAM_KEY);
        return resolveCompositionLocal(compositionLocal, currentCompositionLocalScope$default(this, (Integer) null, 1, (Object) null));
    }

    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
        }
        Object nextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = nextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) nextSlot : null;
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(getCompoundKeyHash(), this.forceRecomposeScopes));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope$default(this, (Integer) null, 1, (Object) null));
        endGroup();
        return compositionContextHolder.getRef();
    }

    private final <T> T resolveCompositionLocal(CompositionLocal<T> compositionLocal, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        if (ComposerKt.contains(persistentMap, compositionLocal)) {
            return ComposerKt.getValueOf(persistentMap, compositionLocal);
        }
        return compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing != 0 || !stack.isNotEmpty()) {
            return null;
        }
        return stack.peek();
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter openWriter = this.insertTable.openWriter();
            this.writer = openWriter;
            openWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close();
        this.writer = openWriter;
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (!(obj == null || this.reader.getGroupAux() == obj)) {
            recordSlotTableOperation$default(this, false, new ComposerImpl$startReaderGroup$1(obj), 1, (Object) null);
        }
        this.reader.startGroup();
    }

    private final void start(int i, Object obj, boolean z, Object obj2) {
        int i2;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i, obj, obj2);
        Pending pending2 = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z) {
                this.writer.startNode(Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                SlotWriter slotWriter = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i, obj, obj2);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (obj == null) {
                    obj = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i, obj);
            }
            Pending pending3 = this.pending;
            if (pending3 != null) {
                KeyInfo keyInfo = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending3.registerInsert(keyInfo, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo);
            }
            enterGroup(z, (Pending) null);
            return;
        }
        if (this.pending == null) {
            if (this.reader.getGroupKey() != i || !Intrinsics.areEqual(obj, this.reader.getGroupObjectKey())) {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            } else {
                startReaderGroup(z, obj2);
            }
        }
        Pending pending4 = this.pending;
        if (pending4 != null) {
            KeyInfo next = pending4.getNext(i, obj);
            if (next != null) {
                pending4.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending4.nodePositionOf(next) + pending4.getStartIndex();
                int slotPositionOf = pending4.slotPositionOf(next);
                int groupIndex = slotPositionOf - pending4.getGroupIndex();
                pending4.registerMoveSlot(slotPositionOf, pending4.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    recordSlotEditingOperation(new ComposerImpl$start$2(groupIndex));
                }
                startReaderGroup(z, obj2);
            } else {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z) {
                    this.writer.startNode(Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i, obj, obj2);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (obj == null) {
                        obj = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i, obj);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending4.registerInsert(keyInfo2, this.nodeIndex - pending4.getStartIndex());
                pending4.recordUsed(keyInfo2);
                List arrayList = new ArrayList();
                if (z) {
                    i2 = 0;
                } else {
                    i2 = this.nodeIndex;
                }
                pending2 = new Pending(arrayList, i2);
            }
        }
        enterGroup(z, pending2);
    }

    private final void enterGroup(boolean z, Pending pending2) {
        this.pendingStack.push(this.pending);
        this.pending = pending2;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i, boolean z) {
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z) {
            pop.setGroupIndex(pop.getGroupIndex() + 1);
        }
        this.pending = pop;
        this.nodeIndex = this.nodeIndexStack.pop() + i;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i;
    }

    private final void end(boolean z) {
        List<KeyInfo> list;
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i = this.groupNodeCount;
        Pending pending2 = this.pending;
        int i2 = 0;
        if (pending2 != null && pending2.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending2.getKeyInfos();
            List<KeyInfo> used = pending2.getUsed();
            Set<T> fastToSet = ListUtilsKt.fastToSet(used);
            Set linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < size2) {
                KeyInfo keyInfo = keyInfos.get(i3);
                if (!fastToSet.contains(keyInfo)) {
                    recordRemoveNode(pending2.nodePositionOf(keyInfo) + pending2.getStartIndex(), keyInfo.getNodes());
                    pending2.updateNodeCount(keyInfo.getLocation(), i2);
                    recordReaderMoving(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else if (!linkedHashSet.contains(keyInfo)) {
                    if (i4 < size) {
                        KeyInfo keyInfo2 = used.get(i4);
                        if (keyInfo2 != keyInfo) {
                            int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                            linkedHashSet.add(keyInfo2);
                            if (nodePositionOf != i5) {
                                int updatedNodeCountOf = pending2.updatedNodeCountOf(keyInfo2);
                                list = used;
                                recordMoveNode(pending2.getStartIndex() + nodePositionOf, i5 + pending2.getStartIndex(), updatedNodeCountOf);
                                pending2.registerMoveNode(nodePositionOf, i5, updatedNodeCountOf);
                            } else {
                                list = used;
                            }
                        } else {
                            list = used;
                            i3++;
                        }
                        i4++;
                        i5 += pending2.updatedNodeCountOf(keyInfo2);
                        used = list;
                    }
                    i2 = 0;
                }
                i3++;
                i2 = 0;
            }
            realizeMovement();
            if (keyInfos.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i6 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(i6, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting2 = getInserting();
        if (inserting2) {
            if (z) {
                registerInsertUpFixup();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int insertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(insertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(insertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (z) {
                recordUp();
            }
            recordEndGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (z) {
                i = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(i, inserting2);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int groupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash2 = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        Invalidation access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        boolean z2 = false;
        int i3 = parent;
        while (access$firstInRange != null) {
            int location = access$firstInRange.getLocation();
            Invalidation unused = ComposerKt.removeLocation(this.invalidations, location);
            if (access$firstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i3, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash2);
                this.providerCache = null;
                access$firstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i3 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(access$firstInRange.getScope());
                access$firstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            access$firstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), groupSize);
        }
        if (z2) {
            recordUpsAndDowns(i3, parent, parent);
            this.reader.skipToGroupEnd();
            int updatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + updatedNodeCount;
            this.groupNodeCount = i2 + updatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash2;
        this.isComposing = z;
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int updatedNodeCount = updatedNodeCount(i);
        if (updatedNodeCount != i2) {
            int i3 = i2 - updatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i != -1) {
                int updatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, updatedNodeCount2);
                int i4 = size;
                while (true) {
                    if (-1 < i4) {
                        Pending peek = this.pendingStack.peek(i4);
                        if (peek != null && peek.updateNodeCount(i, updatedNodeCount2)) {
                            size = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    i = this.reader.getParent();
                } else if (!this.reader.isNode(i)) {
                    i = this.reader.parent(i);
                } else {
                    return;
                }
            }
        }
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int i5;
        int parent = this.reader.parent(i2);
        while (i5 != i3 && !this.reader.isNode(i5)) {
            parent = this.reader.parent(i5);
        }
        if (this.reader.isNode(i5)) {
            i4 = 0;
        }
        if (i5 == i2) {
            return i4;
        }
        int updatedNodeCount = (updatedNodeCount(i5) - this.reader.nodeCount(i2)) + i4;
        loop1:
        while (i4 < updatedNodeCount && i5 != i) {
            i5++;
            while (true) {
                if (i5 >= i) {
                    break loop1;
                }
                int groupSize = this.reader.groupSize(i5) + i5;
                if (i >= groupSize) {
                    i4 += updatedNodeCount(i5);
                    i5 = groupSize;
                }
            }
        }
        return i4;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        Integer num;
        if (i < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null || (num = hashMap.get(Integer.valueOf(i))) == null) {
                return 0;
            }
            return num.intValue();
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null || (i2 = iArr[i]) < 0) {
            return this.reader.nodeCount(i);
        }
        return i2;
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) == i2) {
            return;
        }
        if (i < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap == null) {
                HashMap<Integer, Integer> hashMap2 = new HashMap<>();
                this.nodeCountVirtualOverrides = hashMap2;
                hashMap = hashMap2;
            }
            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            return;
        }
        int[] iArr = this.nodeCountOverrides;
        if (iArr == null) {
            ComposerImpl composerImpl = this;
            int[] iArr2 = new int[composerImpl.reader.getSize()];
            ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
            composerImpl.nodeCountOverrides = iArr2;
            iArr = iArr2;
        }
        iArr[i] = i2;
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        int access$nearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != access$nearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                recordUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, access$nearestCommonRootOf);
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i > 0 && i != i2) {
            doRecordDownsFor(this.reader.parent(i), i2);
            if (this.reader.isNode(i)) {
                recordDown(nodeAt(this.reader, i));
            }
        }
    }

    private final int compoundKeyOf(int i, int i2, int i3) {
        if (i == i2) {
            return i3;
        }
        ComposerImpl composerImpl = this;
        int groupCompoundKeyPart = composerImpl.groupCompoundKeyPart(composerImpl.reader, i);
        if (groupCompoundKeyPart == 126665345) {
            return groupCompoundKeyPart;
        }
        return Integer.rotateLeft(composerImpl.compoundKeyOf(composerImpl.reader.parent(i), i2, i3), 3) ^ groupCompoundKeyPart;
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i) {
        Object groupAux;
        if (slotReader.hasObjectKey(i)) {
            Object groupObjectKey = slotReader.groupObjectKey(i);
            if (groupObjectKey == null) {
                return 0;
            }
            if (groupObjectKey instanceof Enum) {
                return ((Enum) groupObjectKey).ordinal();
            }
            if (groupObjectKey instanceof MovableContent) {
                return MovableContentKt.movableContentKey;
            }
            return groupObjectKey.hashCode();
        }
        int groupKey = slotReader.groupKey(i);
        if (groupKey == 207 && (groupAux = slotReader.groupAux(i)) != null && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
            groupKey = groupAux.hashCode();
        }
        return groupKey;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.slotTable);
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), (Object) null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (this.groupNodeCount == 0) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.scopeSkipped();
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
            } else {
                recomposeToGroupEnd();
            }
        } else {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
            throw new KotlinNothingValueException();
        } else if (getInserting()) {
        } else {
            if (!z) {
                skipReaderToGroupEnd();
                return;
            }
            int currentGroup = this.reader.getCurrentGroup();
            int currentEnd = this.reader.getCurrentEnd();
            for (int i = currentGroup; i < currentEnd; i++) {
                this.reader.forEachData$runtime_release(i, new ComposerImpl$deactivateToEndGroup$2(this, i));
            }
            ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
            this.reader.reposition(currentGroup);
            this.reader.skipToGroupEnd();
        }
    }

    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        start(i, (Object) null, false, (Object) null);
        addRecomposeScope();
        return this;
    }

    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        if (getInserting()) {
            ControlledComposition composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) composition2);
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        Invalidation access$removeLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (Intrinsics.areEqual(next, Composer.Companion.getEmpty())) {
            ControlledComposition composition3 = getComposition();
            Intrinsics.checkNotNull(composition3, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) composition3);
            updateValue(recomposeScopeImpl);
        } else {
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        recomposeScopeImpl.setRequiresRecompose(access$removeLocation != null);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        Function1<Composition, Unit> end;
        RecomposeScopeImpl pop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (pop != null) {
            pop.setRequiresRecompose(false);
        }
        if (!(pop == null || (end = pop.end(this.compositionToken)) == null)) {
            record(new ComposerImpl$endRestartGroup$1$1(end, this));
        }
        if (pop == null || pop.getSkipped$runtime_release() || (!pop.getUsed() && !this.forceRecomposeScopes)) {
            pop = null;
        } else {
            if (pop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                pop.setAnchor(anchor);
            }
            pop.setDefaultsInvalid(false);
        }
        end(false);
        return pop;
    }

    @InternalComposeApi
    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        Intrinsics.checkNotNullParameter(movableContent, "value");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope$default(this, (Integer) null, 1, (Object) null), obj, false);
    }

    /* access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Object obj, boolean z) {
        MovableContent<Object> movableContent2 = movableContent;
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2 = persistentMap;
        Object obj2 = obj;
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        changed(obj2);
        int compoundKeyHash2 = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, (Object) null);
            }
            boolean z2 = !getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), (Object) persistentMap2);
            if (z2) {
                this.providerUpdates.put(Integer.valueOf(this.reader.getCurrentGroup()), persistentMap2);
            }
            start(202, ComposerKt.getCompositionLocalMap(), false, persistentMap2);
            if (!getInserting() || z) {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(694380496, true, new ComposerImpl$invokeMovableContentLambda$1(movableContent, obj2)));
                this.providersInvalid = z3;
            } else {
                this.writerHasAProvider = true;
                this.providerCache = null;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, this.writer.anchor(this.writer.parent(this.writer.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope$default(this, (Integer) null, 1, (Object) null)));
            }
        } finally {
            endGroup();
            this.compoundKeyHash = compoundKeyHash2;
            endMovableGroup();
        }
    }

    @InternalComposeApi
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        Intrinsics.checkNotNullParameter(list, "references");
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slotWriter, Applier<Object> applier2, int i) {
        while (!slotWriter.indexInParent(i)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier2.up();
            }
            slotWriter.endGroup();
        }
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter slotWriter) {
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int i = parent + 1;
        int i2 = 0;
        while (i < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, i)) {
                if (slotWriter.isNode(i)) {
                    i2 = 0;
                }
                i++;
            } else {
                i2 += slotWriter.isNode(i) ? 1 : slotWriter.nodeCount(i);
                i += slotWriter.groupSize(i);
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static final int insertMovableContentGuarded$positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier2) {
        int anchorIndex = slotWriter.anchorIndex(anchor);
        boolean z = true;
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() < anchorIndex);
        insertMovableContentGuarded$positionToParentOf(slotWriter, applier2, anchorIndex);
        int insertMovableContentGuarded$currentNodeIndex = insertMovableContentGuarded$currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < anchorIndex) {
            if (slotWriter.indexInCurrentGroup(anchorIndex)) {
                if (slotWriter.isNode()) {
                    applier2.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    insertMovableContentGuarded$currentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                insertMovableContentGuarded$currentNodeIndex += slotWriter.skipGroup();
            }
        }
        if (slotWriter.getCurrentGroup() != anchorIndex) {
            z = false;
        }
        ComposerKt.runtimeCheck(z);
        return insertMovableContentGuarded$currentNodeIndex;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        SlotTable slotTable2;
        Anchor anchor;
        SlotReader access$getReader$p;
        int[] access$getNodeCountOverrides$p;
        List list2;
        SlotTable slotTable$runtime_release;
        SlotReader openReader;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list3 = this.lateChanges;
        List access$getChanges$p = this.changes;
        try {
            this.changes = list3;
            record(ComposerKt.resetSlotsInstance);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Pair pair = list.get(i);
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.component1();
                MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component2();
                Anchor anchor$runtime_release = movableContentStateReference.getAnchor$runtime_release();
                int anchorIndex = movableContentStateReference.getSlotTable$runtime_release().anchorIndex(anchor$runtime_release);
                Ref.IntRef intRef = new Ref.IntRef();
                realizeUps();
                record(new ComposerImpl$insertMovableContentGuarded$1$1$1(intRef, anchor$runtime_release));
                if (movableContentStateReference2 == null) {
                    if (Intrinsics.areEqual((Object) movableContentStateReference.getSlotTable$runtime_release(), (Object) this.insertTable)) {
                        createFreshInsertTable();
                    }
                    openReader = movableContentStateReference.getSlotTable$runtime_release().openReader();
                    openReader.reposition(anchorIndex);
                    this.writersReaderDelta = anchorIndex;
                    List arrayList = new ArrayList();
                    List list4 = arrayList;
                    recomposeMovableContent$default(this, (ControlledComposition) null, (ControlledComposition) null, (Integer) null, (List) null, new ComposerImpl$insertMovableContentGuarded$1$1$2$1(this, arrayList, openReader, movableContentStateReference), 15, (Object) null);
                    if (!list4.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentGuarded$1$1$2$2(intRef, list4));
                    }
                    Unit unit = Unit.INSTANCE;
                    openReader.close();
                } else {
                    MovableContentState movableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference2);
                    if (movableContentStateResolve$runtime_release == null || (slotTable2 = movableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null) {
                        slotTable2 = movableContentStateReference2.getSlotTable$runtime_release();
                    }
                    if (movableContentStateResolve$runtime_release == null || (slotTable$runtime_release = movableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null || (anchor = slotTable$runtime_release.anchor(0)) == null) {
                        anchor = movableContentStateReference2.getAnchor$runtime_release();
                    }
                    List access$collectNodesFrom = ComposerKt.collectNodesFrom(slotTable2, anchor);
                    if (!access$collectNodesFrom.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentGuarded$1$1$3(intRef, access$collectNodesFrom));
                        if (Intrinsics.areEqual((Object) movableContentStateReference.getSlotTable$runtime_release(), (Object) this.slotTable)) {
                            int anchorIndex2 = this.slotTable.anchorIndex(anchor$runtime_release);
                            updateNodeCount(anchorIndex2, updatedNodeCount(anchorIndex2) + access$collectNodesFrom.size());
                        }
                    }
                    record(new ComposerImpl$insertMovableContentGuarded$1$1$4(movableContentStateResolve$runtime_release, this, movableContentStateReference2, movableContentStateReference));
                    SlotReader openReader2 = slotTable2.openReader();
                    try {
                        access$getReader$p = this.reader;
                        access$getNodeCountOverrides$p = this.nodeCountOverrides;
                        this.nodeCountOverrides = null;
                        this.reader = openReader2;
                        int anchorIndex3 = slotTable2.anchorIndex(anchor);
                        openReader2.reposition(anchorIndex3);
                        this.writersReaderDelta = anchorIndex3;
                        List arrayList2 = new ArrayList();
                        List access$getChanges$p2 = this.changes;
                        try {
                            this.changes = arrayList2;
                            list2 = access$getChanges$p2;
                            try {
                                recomposeMovableContent(movableContentStateReference2.getComposition$runtime_release(), movableContentStateReference.getComposition$runtime_release(), Integer.valueOf(openReader2.getCurrentGroup()), movableContentStateReference2.getInvalidations$runtime_release(), new ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1(this, movableContentStateReference));
                                Unit unit2 = Unit.INSTANCE;
                                this.changes = list2;
                                if (!arrayList2.isEmpty()) {
                                    record(new ComposerImpl$insertMovableContentGuarded$1$1$5$1$2(intRef, arrayList2));
                                }
                                Unit unit3 = Unit.INSTANCE;
                                this.reader = access$getReader$p;
                                this.nodeCountOverrides = access$getNodeCountOverrides$p;
                                Unit unit4 = Unit.INSTANCE;
                                openReader2.close();
                            } catch (Throwable th) {
                                th = th;
                                this.changes = list2;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            list2 = access$getChanges$p2;
                            this.changes = list2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        openReader2.close();
                        throw th3;
                    }
                }
                record(ComposerKt.skipToGroupEndInstance);
            }
            record(ComposerImpl$insertMovableContentGuarded$1$2.INSTANCE);
            this.writersReaderDelta = 0;
            Unit unit5 = Unit.INSTANCE;
            this.changes = access$getChanges$p;
        } catch (Throwable th4) {
            this.changes = access$getChanges$p;
            throw th4;
        }
    }

    private final <R> R withChanges(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list, Function0<? extends R> function0) {
        List access$getChanges$p = this.changes;
        try {
            this.changes = list;
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.changes = access$getChanges$p;
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withReader(SlotReader slotReader, Function0<? extends R> function0) {
        SlotReader access$getReader$p = this.reader;
        int[] access$getNodeCountOverrides$p = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = slotReader;
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            this.reader = access$getReader$p;
            this.nodeCountOverrides = access$getNodeCountOverrides$p;
            InlineMarker.finallyEnd(1);
        }
    }

    static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        ControlledComposition controlledComposition3 = (i & 1) != 0 ? null : controlledComposition;
        ControlledComposition controlledComposition4 = (i & 2) != 0 ? null : controlledComposition2;
        Integer num2 = (i & 4) != 0 ? null : num;
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, Function0<? extends R> function0) {
        R r;
        ControlledComposition controlledComposition3 = controlledComposition;
        boolean z = this.implicitRootStart;
        boolean z2 = this.isComposing;
        int i = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair pair = list.get(i2);
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) pair.component1();
                IdentityArraySet identityArraySet = (IdentityArraySet) pair.component2();
                if (identityArraySet != null) {
                    int size2 = identityArraySet.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        tryImminentInvalidation$runtime_release(recomposeScopeImpl, identityArraySet.get(i3));
                    }
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImpl, (Object) null);
                }
            }
            if (controlledComposition3 != null) {
                r = controlledComposition.delegateInvalidations(controlledComposition2, num != null ? num.intValue() : -1, function0);
                if (r == null) {
                }
                return r;
            }
            Function0<? extends R> function02 = function0;
            r = function0.invoke();
            return r;
        } finally {
            this.implicitRootStart = z;
            this.isComposing = z2;
            this.nodeIndex = i;
        }
    }

    @ComposeCompilerApi
    public void sourceInformation(String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        if (getInserting()) {
            this.writer.insertAux(str);
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        start(i, (Object) null, false, str);
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        end(false);
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(function2, "content");
        if (this.changes.isEmpty()) {
            doCompose(identityArrayMap, function2);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void prepareCompose$runtime_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!this.isComposing) {
            this.isComposing = true;
            try {
                function0.invoke();
            } finally {
                this.isComposing = false;
            }
        } else {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap) {
        Intrinsics.checkNotNullParameter(identityArrayMap, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw new KotlinNothingValueException();
        } else if (!identityArrayMap.isNotEmpty() && !(!this.invalidations.isEmpty()) && !this.forciblyRecompose) {
            return false;
        } else {
            doCompose(identityArrayMap, (Function2<? super Composer, ? super Integer, Unit>) null);
            return !this.changes.isEmpty();
        }
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (!this.isComposing) {
            Object beginSection = Trace.INSTANCE.beginSection("Compose:recompose");
            try {
                Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
                this.snapshot = currentSnapshot;
                this.compositionToken = currentSnapshot.getId();
                this.providerUpdates.clear();
                int size$runtime_release = identityArrayMap.getSize$runtime_release();
                int i = 0;
                while (i < size$runtime_release) {
                    Object obj = identityArrayMap.getKeys$runtime_release()[i];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                    IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues$runtime_release()[i];
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    Anchor anchor = recomposeScopeImpl.getAnchor();
                    if (anchor != null) {
                        this.invalidations.add(new Invalidation(recomposeScopeImpl, anchor.getLocation$runtime_release(), identityArraySet));
                        i++;
                    } else {
                        Trace.INSTANCE.endSection(beginSection);
                        return;
                    }
                }
                List<Invalidation> list = this.invalidations;
                if (list.size() > 1) {
                    CollectionsKt.sortWith(list, new ComposerImpl$doCompose$lambda37$$inlined$sortBy$1());
                }
                this.nodeIndex = 0;
                this.isComposing = true;
                startRoot();
                Object nextSlot = nextSlot();
                if (!(nextSlot == function2 || function2 == null)) {
                    updateValue(function2);
                }
                SnapshotStateKt.observeDerivedStateRecalculations(new ComposerImpl$doCompose$2$3(this), new ComposerImpl$doCompose$2$4(this), new ComposerImpl$doCompose$2$5(function2, this, nextSlot));
                endRoot();
                this.isComposing = false;
                this.invalidations.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(beginSection);
                throw th;
            }
        } else {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void validateNodeNotExpected() {
        if (!(!this.nodeExpected)) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.changes.add(function3);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeUps();
        realizeDowns();
        record(function3);
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation$default(this, false, 1, (Object) null);
        recordSlotEditing();
        record(function3);
    }

    static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.recordSlotTableOperation(z, function3);
    }

    private final void recordSlotTableOperation(boolean z, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation(z);
        record(function3);
    }

    private final void realizeUps() {
        int i = this.pendingUps;
        if (i > 0) {
            this.pendingUps = 0;
            record(new ComposerImpl$realizeUps$1(i));
        }
    }

    private final void realizeDowns(Object[] objArr) {
        record(new ComposerImpl$realizeDowns$1(objArr));
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    private final void recordDown(Object obj) {
        this.downNodes.push(obj);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.realizeOperationLocation(z);
    }

    private final void realizeOperationLocation(boolean z) {
        int parent = z ? this.reader.getParent() : this.reader.getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            ComposerKt.composeRuntimeError("Tried to seek backward".toString());
            throw new KotlinNothingValueException();
        } else if (i > 0) {
            record(new ComposerImpl$realizeOperationLocation$2(i));
            this.writersReaderDelta = parent;
        }
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new ComposerImpl$recordInsert$1(this.insertTable, anchor));
            return;
        }
        List mutableList = CollectionsKt.toMutableList(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new ComposerImpl$recordInsert$2(this.insertTable, anchor, mutableList));
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertFixups.add(function3);
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.insertUpFixups.push(function3);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, boolean z, int i2) {
        ComposerImpl composerImpl2 = composerImpl;
        int i3 = i;
        int i4 = i2;
        int i5 = 1;
        if (composerImpl2.reader.hasMark(i3)) {
            int groupKey = composerImpl2.reader.groupKey(i3);
            Object groupObjectKey = composerImpl2.reader.groupObjectKey(i3);
            if (groupKey == 126665345 && (groupObjectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) groupObjectKey;
                Object groupGet = composerImpl2.reader.groupGet(i3, 0);
                Anchor anchor = composerImpl2.reader.anchor(i3);
                List access$filterToRange = ComposerKt.filterToRange(composerImpl2.invalidations, i3, composerImpl2.reader.groupSize(i3) + i3);
                ArrayList arrayList = new ArrayList(access$filterToRange.size());
                int size = access$filterToRange.size();
                for (int i6 = 0; i6 < size; i6++) {
                    Invalidation invalidation = (Invalidation) access$filterToRange.get(i6);
                    arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
                }
                MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, groupGet, composerImpl.getComposition(), composerImpl2.slotTable, anchor, arrayList, composerImpl2.currentCompositionLocalScope(Integer.valueOf(i)));
                composerImpl2.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
                composerImpl.recordSlotEditing();
                composerImpl2.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(composerImpl2, movableContentStateReference));
                if (!z) {
                    return composerImpl2.reader.nodeCount(i3);
                }
                composerImpl.realizeMovement();
                composerImpl.realizeUps();
                composerImpl.realizeDowns();
                if (!composerImpl2.reader.isNode(i3)) {
                    i5 = composerImpl2.reader.nodeCount(i3);
                }
                if (i5 <= 0) {
                    return 0;
                }
                composerImpl2.recordRemoveNode(i4, i5);
                return 0;
            } else if (groupKey != 206 || !Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                return composerImpl2.reader.nodeCount(i3);
            } else {
                Object groupGet2 = composerImpl2.reader.groupGet(i3, 0);
                CompositionContextHolder compositionContextHolder = groupGet2 instanceof CompositionContextHolder ? (CompositionContextHolder) groupGet2 : null;
                if (compositionContextHolder != null) {
                    for (ComposerImpl reportAllMovableContent : compositionContextHolder.getRef().getComposers()) {
                        reportAllMovableContent.reportAllMovableContent();
                    }
                }
                return composerImpl2.reader.nodeCount(i3);
            }
        } else if (!composerImpl2.reader.containsMark(i3)) {
            return composerImpl2.reader.nodeCount(i3);
        } else {
            int groupSize = composerImpl2.reader.groupSize(i3) + i3;
            int i7 = 0;
            for (int i8 = i3 + 1; i8 < groupSize; i8 += composerImpl2.reader.groupSize(i8)) {
                boolean isNode = composerImpl2.reader.isNode(i8);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl2.recordDown(composerImpl2.reader.node(i8));
                }
                i7 += reportFreeMovableContent$reportGroup(composerImpl2, i8, isNode || z, isNode ? 0 : i4 + i7);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordUp();
                }
            }
            return i7;
        }
    }

    private final void reportFreeMovableContent(int i) {
        reportFreeMovableContent$reportGroup(this, i, false, 0);
        realizeMovement();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public final void releaseMovableGroupAtCurrent(MovableContentStateReference movableContentStateReference, SlotWriter slotWriter) {
        SlotTable slotTable2 = new SlotTable();
        SlotWriter openWriter = slotTable2.openWriter();
        try {
            openWriter.beginInsert();
            openWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime_release());
            SlotWriter.markGroup$default(openWriter, 0, 1, (Object) null);
            openWriter.update(movableContentStateReference.getParameter$runtime_release());
            slotWriter.moveTo(movableContentStateReference.getAnchor$runtime_release(), 1, openWriter);
            openWriter.skipGroup();
            openWriter.endGroup();
            openWriter.endInsert();
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, new MovableContentState(slotTable2));
        } catch (Throwable th) {
            openWriter.close();
            throw th;
        }
    }

    private final void reportAllMovableContent() {
        List access$getChanges$p;
        if (this.slotTable.containsMark()) {
            List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList = new ArrayList<>();
            this.deferredChanges = arrayList;
            SlotReader openReader = this.slotTable.openReader();
            try {
                this.reader = openReader;
                access$getChanges$p = this.changes;
                this.changes = arrayList;
                reportFreeMovableContent(0);
                realizeUps();
                if (this.startedGroup) {
                    record(ComposerKt.skipToGroupEndInstance);
                    recordEndRoot();
                }
                Unit unit = Unit.INSTANCE;
                this.changes = access$getChanges$p;
                Unit unit2 = Unit.INSTANCE;
                openReader.close();
            } catch (Throwable th) {
                openReader.close();
                throw th;
            }
        }
    }

    private final void recordReaderMoving(int i) {
        this.writersReaderDelta = i - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r6.reader;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void recordSlotEditing() {
        /*
            r6 = this;
            androidx.compose.runtime.SlotReader r0 = r6.reader
            int r0 = r0.getSize()
            if (r0 <= 0) goto L_0x0040
            androidx.compose.runtime.SlotReader r0 = r6.reader
            int r1 = r0.getParent()
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r3 = -2
            int r2 = r2.peekOr(r3)
            if (r2 == r1) goto L_0x0040
            boolean r2 = r6.startedGroup
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x002b
            boolean r2 = r6.implicitRootStart
            if (r2 == 0) goto L_0x002b
            kotlin.jvm.functions.Function3 r2 = androidx.compose.runtime.ComposerKt.startRootGroup
            recordSlotTableOperation$default(r6, r4, r2, r5, r3)
            r6.startedGroup = r5
        L_0x002b:
            if (r1 <= 0) goto L_0x0040
            androidx.compose.runtime.Anchor r0 = r0.anchor(r1)
            androidx.compose.runtime.IntStack r2 = r6.startedGroups
            r2.push(r1)
            androidx.compose.runtime.ComposerImpl$recordSlotEditing$1 r1 = new androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            recordSlotTableOperation$default(r6, r4, r1, r5, r3)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recordSlotEditing():void");
    }

    private final void recordEndGroup() {
        int parent = this.reader.getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.peekOr(-1) == parent) {
            this.startedGroups.pop();
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, (Object) null);
            this.startedGroup = false;
        }
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance".toString());
            throw new KotlinNothingValueException();
        } else if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
            throw new KotlinNothingValueException();
        }
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void recordRemoveNode(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + i).toString());
                throw new KotlinNothingValueException();
            } else if (this.previousRemove == i) {
                this.previousCount += i2;
            } else {
                realizeMovement();
                this.previousRemove = i;
                this.previousCount = i2;
            }
        }
    }

    private final void recordMoveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.previousCount;
            if (i4 > 0 && this.previousMoveFrom == i - i4 && this.previousMoveTo == i2 - i4) {
                this.previousCount = i4 + i3;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = i;
            this.previousMoveTo = i2;
            this.previousCount = i3;
        }
    }

    private final void realizeMovement() {
        int i = this.previousCount;
        this.previousCount = 0;
        if (i > 0) {
            int i2 = this.previousRemove;
            if (i2 >= 0) {
                this.previousRemove = -1;
                recordApplierOperation(new ComposerImpl$realizeMovement$1(i2, i));
                return;
            }
            int i3 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            int i4 = this.previousMoveTo;
            this.previousMoveTo = -1;
            recordApplierOperation(new ComposerImpl$realizeMovement$2(i3, i4, i));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Composer.kt */
    private static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            Intrinsics.checkNotNullParameter(compositionContextImpl, "ref");
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020+0/¢\u0006\u0002\b0H\u0010¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020+J\r\u00108\u001a\u00020+H\u0010¢\u0006\u0002\b9J-\u0010\u0015\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0010¢\u0006\u0002\bBJ\u001d\u0010C\u001a\u00020+2\u0006\u00104\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\bFJ\u0017\u0010G\u001a\u0004\u0018\u00010E2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\bHJ\u001b\u0010I\u001a\u00020+2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\"0\nH\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020+H\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020+2\u0006\u0010M\u001a\u00020NH\u0010¢\u0006\u0002\bUJ\u0015\u0010V\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0010¢\u0006\u0002\bWJ.\u0010X\u001a\u00020+2&\u0010@\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRk\u0010\u0014\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00132&\u0010\u000e\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00120\u000fj\u0002`\u00138B@BX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\n\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001e8PX\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010 ¨\u0006Y"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Composer.kt */
    private final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExtensionsKt.persistentHashMapOf(), (SnapshotMutationPolicy) null, 2, (Object) null);
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        public CompositionContextImpl(int i, boolean z) {
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
        }

        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        public final void dispose() {
            if (!this.composers.isEmpty()) {
                Set<Set<CompositionData>> set = this.inspectionTables;
                if (set != null) {
                    for (ComposerImpl next : this.composers) {
                        for (Set<CompositionData> remove : set) {
                            remove.remove(next.slotTable);
                        }
                    }
                }
                this.composers.clear();
            }
        }

        public void registerComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        public void unregisterComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (Set remove : set) {
                    remove.remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public CoroutineContext getEffectCoroutineContext$runtime_release() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext$runtime_release();
        }

        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            Intrinsics.checkNotNullParameter(function2, "content");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(controlledComposition, function2);
        }

        public void invalidate$runtime_release(ControlledComposition controlledComposition) {
            Intrinsics.checkNotNullParameter(controlledComposition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(controlledComposition);
        }

        public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
            Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        private final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope() {
            return (PersistentMap) this.compositionLocalScope$delegate.getValue();
        }

        private final void setCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            this.compositionLocalScope$delegate.setValue(persistentMap);
        }

        public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "scope");
            setCompositionLocalScope(persistentMap);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
            Intrinsics.checkNotNullParameter(set, "table");
            Set<Set<CompositionData>> set2 = this.inspectionTables;
            if (set2 == null) {
                set2 = new HashSet<>();
                this.inspectionTables = set2;
            }
            set2.add(set);
        }

        public void startComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing + 1;
        }

        public void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing = composerImpl.childrenComposing - 1;
        }

        public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
        }

        public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference);
        }

        public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
            Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
            Intrinsics.checkNotNullParameter(movableContentState, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i) {
        this.compoundKeyHash = i ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i, Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null || i != 207 || Intrinsics.areEqual(obj2, Composer.Companion.getEmpty())) {
                updateCompoundKeyWhenWeExitGroupKeyHash(i);
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
            }
        } else if (obj instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i) {
        this.compoundKeyHash = Integer.rotateRight(i ^ getCompoundKeyHash(), 3);
    }

    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    public Object rememberedValue() {
        return nextSlot();
    }

    public void updateRememberedValue(Object obj) {
        updateValue(obj);
    }

    public void recordUsed(RecomposeScope recomposeScope) {
        Intrinsics.checkNotNullParameter(recomposeScope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    public final void dispose$runtime_release() {
        Object beginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(beginSection);
        }
    }

    private final PersistentMap<CompositionLocal<Object>, State<Object>> updateProviderMapGroup(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        builder.putAll(persistentMap2);
        PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> build = builder.build();
        startGroup(204, ComposerKt.getProviderMaps());
        changed((Object) build);
        changed((Object) persistentMap2);
        endGroup();
        return build;
    }
}
