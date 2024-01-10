package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\"\b \u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0002\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J,\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0007H\u0016J \u0010\u0001\u001a\u00020K2\u0006\u0010J\u001a\u00020KH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00020@2\b\u0010\u0001\u001a\u00030\u0001H&J\t\u0010\u0001\u001a\u00020\u0007H\u0016J*\u0010\u0001\u001a\u00020\u001a2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010J\u001a\u00020KH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006J\u001c\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0012\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0018\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0001J\"\u0010\u0001\u001a\u00030\u00012\u0007\u0010]\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 H\u0002J$\u0010¡\u0001\u001a\u00020 2\f\u0010¢\u0001\u001a\u0007\u0012\u0002\b\u00030£\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001J6\u0010¦\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0007\b\u0000\u0010§\u0001\u0018\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u0001H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0014\u0010ª\u0001\u001a\u0004\u0018\u00010q2\u0007\u0010«\u0001\u001a\u00020 H\u0002J1\u0010¬\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b­\u0001\u0010©\u0001J`\u0010®\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¶\u0001\u0010·\u0001Jb\u0010¸\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¹\u0001\u0010·\u0001J\t\u0010º\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010»\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\"\u0010¼\u0001\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0007\u0010¿\u0001\u001a\u00020 J\u001c\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020 H\u0016J,\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010Ä\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J#\u0010Ç\u0001\u001a\u00030\u00012\b\u0010È\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u0001J#\u0010Ê\u0001\u001a\u00030\u00012\b\u0010È\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u0001J#\u0010Ì\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u0001J\u0007\u0010Î\u0001\u001a\u00020\u0007J\"\u0010Ï\u0001\u001a\u00020\u00072\u0019\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1J\t\u0010Ð\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010Ñ\u0001\u001a\u00020\u00072\u0007\u0010Ò\u0001\u001a\u00020Q2\u0007\u0010Ó\u0001\u001a\u00020QH\u0014J\u0007\u0010Ô\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0012\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J7\u0010×\u0001\u001a\u00030Ø\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u000e\u0010Û\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010$H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001JC\u0010Þ\u0001\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u001a2\u0019\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010à\u0001J\u001d\u0010á\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030Á\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010â\u0001J,\u0010ã\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u000e2\u0007\u0010\u0001\u001a\u00020 2\t\b\u0002\u0010ä\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bå\u0001J\u000f\u0010æ\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bç\u0001J\u0007\u0010è\u0001\u001a\u00020 J\"\u0010é\u0001\u001a\u00030\u00012\u0007\u0010]\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bê\u0001\u0010\u0001J\b\u0010ë\u0001\u001a\u00030Á\u0001J+\u0010ì\u0001\u001a\u00020\u00072\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010í\u0001\u001a\u00030î\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bï\u0001\u0010ð\u0001J+\u0010ñ\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030î\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030î\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ó\u0001J\t\u0010ö\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010÷\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020@H\u0004J\u001b\u0010ø\u0001\u001a\u00020\u00072\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\bù\u0001JL\u0010ú\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010§\u0001\u0018\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u00012\u0014\u0010Û\u0001\u001a\u000f\u0012\u0005\u0012\u0003H§\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bû\u0001\u0010ü\u0001J4\u0010ú\u0001\u001a\u00020\u00072\u0007\u0010ý\u0001\u001a\u00020Q2\u0007\u0010«\u0001\u001a\u00020 2\u0013\u0010Û\u0001\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J#\u0010þ\u0001\u001a\u00030\u00012\b\u0010ÿ\u0001\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J+\u0010\u0002\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00062\u0013\u0010Û\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0003J\"\u0010\u0002\u001a\u00020 2\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010¾\u0001Ji\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002Jr\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002Jr\u0010\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 2\u0007\u0010\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\r\u0010\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010,@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/RD\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b12\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u0002088VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010)\u001a\u0004\u0018\u00010@@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR$\u0010E\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f8P@PX\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020K8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001c\u0010N\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0015R\u0013\u0010T\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bU\u0010\u0018R\u0016\u0010V\u001a\u0004\u0018\u00010W8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b[\u0010\u0018R/\u0010]\u001a\u00020\\2\u0006\u0010)\u001a\u00020\\@TX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b^\u0010M\"\u0004\b_\u0010`R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020P0c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020\u000e8DX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020j8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bk\u0010MR\u0014\u0010l\u001a\u00020m8BX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0012\u0010p\u001a\u00020qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010y\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR$\u0010|\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u001c\"\u0004\b~\u0010\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValid", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadDelegate;", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "()J", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "attach", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "createLookaheadDelegate", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "detach", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", "other", "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "T", "head-H91voCI", "(I)Ljava/lang/Object;", "headNode", "includeTail", "headUnchecked", "headUnchecked-H91voCI", "hitTest", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onInitialize", "onLayerBlockUpdated", "onLayoutModifierNodeChanged", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerParameters", "updateLookaheadDelegate", "updateLookaheadScope", "updateLookaheadScope$ui_release", "visitNodes", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    public static final HitTestSource<PointerInputModifierNode> PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    public static final HitTestSource<SemanticsModifierNode> SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m2133constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity = getLayoutNode().getDensity();
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    public LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private LookaheadDelegate lookaheadDelegate;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m4832getZeronOccac();
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H&ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "N", "Landroidx/compose/ui/node/DelegatableNode;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m3917childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult<N> hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m3918entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(N n);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    public abstract LookaheadDelegate createLookaheadDelegate(LookaheadScope lookaheadScope);

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild$ui_release();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Modifier.Node tail = getTail();
        if (z || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(z);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(access$headNode);
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m3910visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        boolean r0 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (r0 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r0);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node = access$headNode;
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node instanceof Object) {
                        function1.invoke(node);
                    }
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    public final boolean m3896hasNodeH91voCI(int i) {
        Modifier.Node headNode = headNode(NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m3746has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final /* synthetic */ <T> T m3897headH91voCI(int i) {
        boolean r0 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(i);
        T tail = getTail();
        if (!r0 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        T access$headNode = headNode(r0);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return (Object) ((Modifier.Node) access$headNode);
            } else if (access$headNode == tail) {
                return null;
            } else {
                access$headNode = access$headNode.getChild$ui_release();
            }
        }
        return null;
    }

    /* renamed from: headUnchecked-H91voCI  reason: not valid java name */
    public final <T> T m3898headUncheckedH91voCI(int i) {
        boolean r0 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(i);
        T tail = getTail();
        if (!r0 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        T access$headNode = headNode(r0);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i) != 0) {
                return (Object) access$headNode;
            }
            if (access$headNode == tail) {
                return null;
            }
            access$headNode = access$headNode.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m3895getSizeYbymL2g() {
        return m3684getMeasuredSizeYbymL2g();
    }

    /* access modifiers changed from: protected */
    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public void replace$ui_release() {
        m3906placeAtf8xVGno(m3894getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public boolean isAttached() {
        return getTail().isAttached();
    }

    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "value");
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (!(measureResult2 != null && measureResult.getWidth() == measureResult2.getWidth() && measureResult.getHeight() == measureResult2.getHeight())) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map<AlignmentLine, Integer> map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap<>();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    public final LookaheadDelegate getLookaheadDelegate$ui_release() {
        return this.lookaheadDelegate;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [androidx.compose.ui.layout.LookaheadScope] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateLookaheadScope$ui_release(androidx.compose.ui.layout.LookaheadScope r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0019
            androidx.compose.ui.node.LookaheadDelegate r1 = r2.lookaheadDelegate
            if (r1 == 0) goto L_0x000b
            androidx.compose.ui.layout.LookaheadScope r0 = r1.getLookaheadScope()
        L_0x000b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0016
            androidx.compose.ui.node.LookaheadDelegate r3 = r2.createLookaheadDelegate(r3)
            goto L_0x0018
        L_0x0016:
            androidx.compose.ui.node.LookaheadDelegate r3 = r2.lookaheadDelegate
        L_0x0018:
            r0 = r3
        L_0x0019:
            r2.lookaheadDelegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.updateLookaheadScope$ui_release(androidx.compose.ui.layout.LookaheadScope):void");
    }

    /* access modifiers changed from: protected */
    public final void updateLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set<AlignmentLine> set = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (set == null) {
                    set = new LinkedHashSet<>();
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    /* access modifiers changed from: protected */
    public void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m3946resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
        m3687setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        int r4 = Nodes.INSTANCE.m3933getDrawOLwlOKw();
        boolean r5 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(r4);
        Modifier.Node tail = getTail();
        if (r5 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r5);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r4) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r4) != 0 && (access$headNode instanceof DrawModifierNode)) {
                    ((DrawModifierNode) access$headNode).onMeasureResultChanged();
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m3894getPositionnOccac() {
        return this.position;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m3907setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* access modifiers changed from: protected */
    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    public Object getParentData() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Modifier.Node tail = getTail();
        Density density = getLayoutNode().getDensity();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release != tail) {
                if (((Nodes.INSTANCE.m3939getParentDataOLwlOKw() & tail$ui_release.getKindSet$ui_release()) != 0) && (tail$ui_release instanceof ParentDataModifierNode)) {
                    objectRef.element = ((ParentDataModifierNode) tail$ui_release).modifyParentData(density, objectRef.element);
                }
            }
        }
        return objectRef.element;
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* access modifiers changed from: protected */
    /* renamed from: performingMeasure-K40F9xA  reason: not valid java name */
    public final Placeable m3905performingMeasureK40F9xA(long j, Function0<? extends Placeable> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        m3688setMeasurementConstraintsBRTryo0(j);
        Placeable placeable = (Placeable) function0.invoke();
        OwnedLayer layer2 = getLayer();
        if (layer2 != null) {
            layer2.m3946resizeozmzZPI(m3684getMeasuredSizeYbymL2g());
        }
        return placeable;
    }

    public final void onMeasured() {
        Snapshot makeCurrent;
        Modifier.Node node;
        if (m3896hasNodeH91voCI(Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw())) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                int r2 = Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw();
                boolean r3 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(r2);
                if (r3) {
                    node = getTail();
                } else {
                    node = getTail().getParent$ui_release();
                    if (node == null) {
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                    }
                }
                Modifier.Node access$headNode = headNode(r3);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r2) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r2) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) access$headNode).m3774onRemeasuredozmzZPI(m3684getMeasuredSizeYbymL2g());
                    }
                    if (access$headNode == node) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
                Unit unit2 = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
    }

    public final void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m3906placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        onLayerBlockUpdated(function1);
        if (!IntOffset.m4821equalsimpl0(m3894getPositionnOccac(), j)) {
            m3907setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m3945movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float r0 = (float) IntOffset.m4822getXimpl(m3894getPositionnOccac());
        float r1 = (float) IntOffset.m4823getYimpl(m3894getPositionnOccac());
        canvas.translate(r0, r1);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-r0, -r1);
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int r0 = Nodes.INSTANCE.m3933getDrawOLwlOKw();
        boolean r1 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(r0);
        DrawModifierNode drawModifierNode = null;
        Modifier.Node tail = getTail();
        if (r1 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r1);
            while (true) {
                if (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r0) == 0) {
                        if (access$headNode == tail) {
                            break;
                        }
                        access$headNode = access$headNode.getChild$ui_release();
                    } else {
                        if (access$headNode instanceof DrawModifierNode) {
                            drawModifierNode = access$headNode;
                        }
                        drawModifierNode = drawModifierNode;
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode drawModifierNode2 = drawModifierNode;
        if (drawModifierNode2 == null) {
            performDraw(canvas);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m3795drawx_KDEd0$ui_release(canvas, IntSizeKt.m4874toSizeozmzZPI(m3895getSizeYbymL2g()), this, drawModifierNode2);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        if (lookaheadDelegate2 != null) {
            int r1 = Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw();
            boolean r2 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(r1);
            Modifier.Node tail = getTail();
            if (r2 || (tail = tail.getParent$ui_release()) != null) {
                Modifier.Node access$headNode = headNode(r2);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r1) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r1) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) access$headNode).onLookaheadPlaced(lookaheadDelegate2.getLookaheadLayoutCoordinates());
                    }
                    if (access$headNode == tail) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
            }
        }
        int r0 = Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw();
        boolean r12 = NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(r0);
        Modifier.Node tail2 = getTail();
        if (r12 || (tail2 = tail2.getParent$ui_release()) != null) {
            Modifier.Node access$headNode2 = headNode(r12);
            while (access$headNode2 != null && (access$headNode2.getAggregateChildKindSet$ui_release() & r0) != 0) {
                if ((access$headNode2.getKindSet$ui_release() & r0) != 0 && (access$headNode2 instanceof LayoutAwareModifierNode)) {
                    ((LayoutAwareModifierNode) access$headNode2).onPlaced(this);
                }
                if (access$headNode2 != tail2) {
                    access$headNode2 = access$headNode2.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public void invoke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new NodeCoordinator$invoke$1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }

    public final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> function1) {
        Owner owner$ui_release;
        boolean z = (this.layerBlock == function1 && Intrinsics.areEqual((Object) this.layerDensity, (Object) getLayoutNode().getDensity()) && this.layerLayoutDirection == getLayoutNode().getLayoutDirection()) ? false : true;
        this.layerBlock = function1;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (!isAttached() || function1 == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
            createLayer.m3946resizeozmzZPI(m3684getMeasuredSizeYbymL2g());
            createLayer.m3945movegyyYBs(m3894getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (z) {
            updateLayerParameters();
        }
    }

    /* access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                graphicsLayerScope.reset();
                graphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function1));
                LayerPositionalProperties layerPositionalProperties2 = this.layerPositionalProperties;
                if (layerPositionalProperties2 == null) {
                    layerPositionalProperties2 = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties2;
                }
                layerPositionalProperties2.copyFrom((GraphicsLayerScope) graphicsLayerScope);
                ownedLayer.m3948updateLayerPropertiesNHXXZp8(graphicsLayerScope.getScaleX(), graphicsLayerScope.getScaleY(), graphicsLayerScope.getAlpha(), graphicsLayerScope.getTranslationX(), graphicsLayerScope.getTranslationY(), graphicsLayerScope.getShadowElevation(), graphicsLayerScope.getRotationX(), graphicsLayerScope.getRotationY(), graphicsLayerScope.getRotationZ(), graphicsLayerScope.getCameraDistance(), graphicsLayerScope.m2234getTransformOriginSzJe1aQ(), graphicsLayerScope.getShape(), graphicsLayerScope.getClip(), graphicsLayerScope.getRenderEffect(), graphicsLayerScope.m2232getAmbientShadowColor0d7_KjU(), graphicsLayerScope.m2233getSpotShadowColor0d7_KjU(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
                this.isClipping = graphicsLayerScope.getClip();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public boolean isValid() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m3893getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m4650toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m4057getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final <T extends DelegatableNode> void m3899hitTestYqVAtuI(HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        float f;
        long j2 = j;
        HitTestResult<T> hitTestResult2 = hitTestResult;
        HitTestSource<T> hitTestSource2 = hitTestSource;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult2, "hitTestResult");
        DelegatableNode delegatableNode = (DelegatableNode) m3898headUncheckedH91voCI(hitTestSource.m3918entityTypeOLwlOKw());
        boolean z3 = true;
        if (!m3912withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float r8 = m3891distanceInMinimumTouchTargettz77jQw(j, m3893getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(r8) || Float.isNaN(r8)) {
                    z3 = false;
                }
                if (z3 && hitTestResult2.isHitInMinimumTouchTargetBetter(r8, false)) {
                    m3885hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, false, r8);
                }
            }
        } else if (delegatableNode == null) {
            m3900hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (m3901isPointerInBoundsk4lQ0M(j)) {
            m3884hit1hIXUjU(delegatableNode, hitTestSource, j, hitTestResult, z, z2);
        } else {
            if (!z) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m3891distanceInMinimumTouchTargettz77jQw(j, m3893getMinimumTouchTargetSizeNHjbRc());
            }
            if (Float.isInfinite(f) || Float.isNaN(f)) {
                z3 = false;
            }
            boolean z4 = z2;
            if (!z3 || !hitTestResult2.isHitInMinimumTouchTargetBetter(f, z4)) {
                m3887speculativeHitJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, f);
            } else {
                m3885hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final <T extends DelegatableNode> void m3884hit1hIXUjU(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        if (t == null) {
            m3900hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        hitTestResult.hit(t, z2, new NodeCoordinator$hit$1(this, t, hitTestSource, j, hitTestResult, z, z2));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m3885hitNearJHbHoSQ(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2, float f) {
        if (t == null) {
            m3900hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float f2 = f;
        hitTestResult.hitInMinimumTouchTarget(t, f2, z2, new NodeCoordinator$hitNear$1(this, t, hitTestSource, j, hitTestResult, z, z2, f));
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m3887speculativeHitJHbHoSQ(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2, float f) {
        if (t == null) {
            m3900hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        HitTestSource<T> hitTestSource2 = hitTestSource;
        if (hitTestSource.interceptOutOfBoundsChildEvents(t)) {
            boolean z3 = z2;
            float f2 = f;
            hitTestResult.speculativeHit(t, f2, z3, new NodeCoordinator$speculativeHit$1(this, t, hitTestSource, j, hitTestResult, z, z3, f2));
            return;
        }
        HitTestResult<T> hitTestResult2 = hitTestResult;
        m3887speculativeHitJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m3920nextUncheckedUntilhw7D004(t, hitTestSource.m3918entityTypeOLwlOKw(), Nodes.INSTANCE.m3936getLayoutOLwlOKw()), hitTestSource, j, hitTestResult, z, z2, f);
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public <T extends DelegatableNode> void m3900hitTestChildYqVAtuI(HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m3899hitTestYqVAtuI(hitTestSource, nodeCoordinator.m3892fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long r2 = m3890calculateMinimumTouchTargetPaddingE7KxVPU(m3893getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1752getWidthimpl(r2));
        rectCache.setTop(-Size.m1749getHeightimpl(r2));
        rectCache.setRight(((float) getMeasuredWidth()) + Size.m1752getWidthimpl(r2));
        rectCache.setBottom(((float) getMeasuredHeight()) + Size.m1749getHeightimpl(r2));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m3911windowToLocalMKHz9U(long j) {
        if (isAttached()) {
            LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
            return m3902localPositionOfR5De75A(findRootCoordinates, Offset.m1687minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m3949calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m3904localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m3950calculatePositionInWindowMKHz9U(m3903localToRootMKHz9U(j));
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m3902localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m3908toParentPositionMKHz9U(j);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m3883ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m3909transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m2142resetimpl(fArr);
        coordinator.m3889transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m3888transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m3889transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual((Object) nodeCoordinator2, (Object) nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.m3947transform58bKbWc(fArr);
            }
            long r1 = nodeCoordinator2.m3894getPositionnOccac();
            if (!IntOffset.m4821equalsimpl0(r1, IntOffset.Companion.m4832getZeronOccac())) {
                Matrix.m2142resetimpl(tmpMatrix);
                Matrix.m2153translateimpl$default(tmpMatrix, (float) IntOffset.m4822getXimpl(r1), (float) IntOffset.m4823getYimpl(r1), 0.0f, 4, (Object) null);
                Matrix.m2150timesAssign58bKbWc(fArr, tmpMatrix);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m3888transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (!Intrinsics.areEqual((Object) nodeCoordinator, (Object) this)) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            nodeCoordinator2.m3888transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
            if (!IntOffset.m4821equalsimpl0(m3894getPositionnOccac(), IntOffset.Companion.m4832getZeronOccac())) {
                Matrix.m2142resetimpl(tmpMatrix);
                Matrix.m2153translateimpl$default(tmpMatrix, -((float) IntOffset.m4822getXimpl(m3894getPositionnOccac())), -((float) IntOffset.m4823getYimpl(m3894getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m2150timesAssign58bKbWc(fArr, tmpMatrix);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m3942inverseTransform58bKbWc(fArr);
            }
        }
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (layoutCoordinates.isAttached()) {
            NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
            NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
            MutableRect rectCache = getRectCache();
            rectCache.setLeft(0.0f);
            rectCache.setTop(0.0f);
            rectCache.setRight((float) IntSize.m4864getWidthimpl(layoutCoordinates.m3611getSizeYbymL2g()));
            rectCache.setBottom((float) IntSize.m4863getHeightimpl(layoutCoordinates.m3611getSizeYbymL2g()));
            while (coordinator != findCommonAncestor$ui_release) {
                rectInParent$ui_release$default(coordinator, rectCache, z, false, 4, (Object) null);
                if (rectCache.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                coordinator = coordinator.wrappedBy;
                Intrinsics.checkNotNull(coordinator);
            }
            ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
            return MutableRectKt.toRect(rectCache);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m3883ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual((Object) nodeCoordinator, (Object) nodeCoordinator2)) {
            return m3892fromParentPositionMKHz9U(j);
        }
        return m3892fromParentPositionMKHz9U(nodeCoordinator2.m3883ancestorToLocalR5De75A(nodeCoordinator, j));
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator != this) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
            }
            fromParentRect(mutableRect, z);
        }
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m3903localToRootMKHz9U(long j) {
        if (isAttached()) {
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
                j = nodeCoordinator.m3908toParentPositionMKHz9U(j);
            }
            return j;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* access modifiers changed from: protected */
    public final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        float r0 = (float) IntOffset.m4822getXimpl(m3894getPositionnOccac());
        float r1 = (float) IntOffset.m4823getYimpl(m3894getPositionnOccac());
        canvas.translate(r0, r1);
        function1.invoke(canvas);
        canvas.translate(-r0, -r1);
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m3908toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.m3944mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.m4836plusNvtHpc(j, m3894getPositionnOccac());
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m3892fromParentPositionMKHz9U(long j) {
        long r3 = IntOffsetKt.m4834minusNvtHpc(j, m3894getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.m3944mapOffset8S9VItk(r3, true) : r3;
    }

    /* access modifiers changed from: protected */
    public final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m4864getWidthimpl(m3684getMeasuredSizeYbymL2g())) - 0.5f, ((float) IntSize.m4863getHeightimpl(m3684getMeasuredSizeYbymL2g())) - 0.5f), paint);
    }

    public void attach() {
        onLayerBlockUpdated(this.layerBlock);
    }

    public void detach() {
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mutableRect, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long r8 = m3893getMinimumTouchTargetSizeNHjbRc();
                    float r1 = Size.m1752getWidthimpl(r8) / 2.0f;
                    float r82 = Size.m1749getHeightimpl(r8) / 2.0f;
                    mutableRect.intersect(-r1, -r82, ((float) IntSize.m4864getWidthimpl(m3895getSizeYbymL2g())) + r1, ((float) IntSize.m4863getHeightimpl(m3895getSizeYbymL2g())) + r82);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m4864getWidthimpl(m3895getSizeYbymL2g()), (float) IntSize.m4863getHeightimpl(m3895getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float r83 = (float) IntOffset.m4822getXimpl(m3894getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + r83);
        mutableRect.setRight(mutableRect.getRight() + r83);
        float r84 = (float) IntOffset.m4823getYimpl(m3894getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + r84);
        mutableRect.setBottom(mutableRect.getBottom() + r84);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float r0 = (float) IntOffset.m4822getXimpl(m3894getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - r0);
        mutableRect.setRight(mutableRect.getRight() - r0);
        float r02 = (float) IntOffset.m4823getYimpl(m3894getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - r02);
        mutableRect.setBottom(mutableRect.getBottom() - r02);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m4864getWidthimpl(m3895getSizeYbymL2g()), (float) IntSize.m4863getHeightimpl(m3895getSizeYbymL2g()));
                if (mutableRect.isEmpty()) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: withinLayerBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m3912withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m1700isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping || ownedLayer.m3943isInLayerk4lQ0M(j)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: isPointerInBounds-k-4lQ0M  reason: not valid java name */
    public final boolean m3901isPointerInBoundsk4lQ0M(long j) {
        float r0 = Offset.m1683getXimpl(j);
        float r3 = Offset.m1684getYimpl(j);
        return r0 >= 0.0f && r3 >= 0.0f && r0 < ((float) getMeasuredWidth()) && r3 < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator nodeCoordinator, Rect rect, Continuation continuation) {
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        if (nodeCoordinator2 == null) {
            return Unit.INSTANCE;
        }
        Object propagateRelocationRequest = nodeCoordinator2.propagateRelocationRequest(rect.m1720translatek4lQ0M(nodeCoordinator2.localBoundingBoxOf(nodeCoordinator, false).m1718getTopLeftF1C5BW0()), continuation);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "other");
        LayoutNode layoutNode2 = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode3 = getLayoutNode();
        if (layoutNode2 == layoutNode3) {
            Modifier.Node tail = nodeCoordinator.getTail();
            DelegatableNode tail2 = getTail();
            int r2 = Nodes.INSTANCE.m3936getLayoutOLwlOKw();
            if (tail2.getNode().isAttached()) {
                for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                    if ((parent$ui_release.getKindSet$ui_release() & r2) != 0 && parent$ui_release == tail) {
                        return nodeCoordinator;
                    }
                }
                return this;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode3.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode3.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode3);
        }
        while (layoutNode2 != layoutNode3) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            layoutNode3 = layoutNode3.getParent$ui_release();
            if (layoutNode2 != null) {
                if (layoutNode3 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode3 == getLayoutNode()) {
            return this;
        }
        return layoutNode2 == nodeCoordinator.getLayoutNode() ? nodeCoordinator : layoutNode2.getInnerCoordinator$ui_release();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier.Node headNode = headNode(NodeKindKt.m3930getIncludeSelfInTraversalH91voCI(Nodes.INSTANCE.m3940getPointerInputOLwlOKw()));
        if (headNode == null) {
            return false;
        }
        DelegatableNode delegatableNode = headNode;
        int r2 = Nodes.INSTANCE.m3940getPointerInputOLwlOKw();
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & r2) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & r2) != 0 && (child$ui_release instanceof PointerInputModifierNode) && ((PointerInputModifierNode) child$ui_release).sharePointerInputWithSiblings()) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m3886offsetFromEdgeMKHz9U(long j) {
        float f;
        float f2;
        float r0 = Offset.m1683getXimpl(j);
        if (r0 < 0.0f) {
            f = -r0;
        } else {
            f = r0 - ((float) getMeasuredWidth());
        }
        float max = Math.max(0.0f, f);
        float r4 = Offset.m1684getYimpl(j);
        if (r4 < 0.0f) {
            f2 = -r4;
        } else {
            f2 = r4 - ((float) getMeasuredHeight());
        }
        return OffsetKt.Offset(max, Math.max(0.0f, f2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU  reason: not valid java name */
    public final long m3890calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m1752getWidthimpl(j) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m1749getHeightimpl(j) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: distanceInMinimumTouchTarget-tz77jQw  reason: not valid java name */
    public final float m3891distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (((float) getMeasuredWidth()) >= Size.m1752getWidthimpl(j2) && ((float) getMeasuredHeight()) >= Size.m1749getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long r6 = m3890calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float r0 = Size.m1752getWidthimpl(r6);
        float r62 = Size.m1749getHeightimpl(r6);
        long r4 = m3886offsetFromEdgeMKHz9U(j);
        if ((r0 > 0.0f || r62 > 0.0f) && Offset.m1683getXimpl(r4) <= r0 && Offset.m1684getYimpl(r4) <= r62) {
            return Offset.m1682getDistanceSquaredimpl(r4);
        }
        return Float.POSITIVE_INFINITY;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInputSource$annotations", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        private Companion() {
        }

        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
