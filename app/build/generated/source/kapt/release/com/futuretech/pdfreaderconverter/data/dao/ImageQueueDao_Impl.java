package com.futuretech.pdfreaderconverter.data.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ImageQueueDao_Impl implements ImageQueueDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ImageQueue> __insertionAdapterOfImageQueue;

  private final EntityDeletionOrUpdateAdapter<ImageQueue> __deletionAdapterOfImageQueue;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllQueueImages;

  public ImageQueueDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImageQueue = new EntityInsertionAdapter<ImageQueue>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ImageQueue` (`uriPath`,`isSelected`,`id`) VALUES (?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageQueue value) {
        if (value.getUriPath() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUriPath());
        }
        final int _tmp = value.isSelected() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        stmt.bindLong(3, value.getId());
      }
    };
    this.__deletionAdapterOfImageQueue = new EntityDeletionOrUpdateAdapter<ImageQueue>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ImageQueue` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageQueue value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllQueueImages = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from ImageQueue";
        return _query;
      }
    };
  }

  @Override
  public Object insertQueueImage(final ImageQueue queueImage,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfImageQueue.insert(queueImage);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteQueueImage(final ImageQueue queueImage,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfImageQueue.handle(queueImage);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public int deleteAllQueueImages() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllQueueImages.acquire();
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllQueueImages.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ImageQueue>> getAllQueueImage() {
    final String _sql = "SELECT * from ImageQueue order by id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ImageQueue"}, false, new Callable<List<ImageQueue>>() {
      @Override
      public List<ImageQueue> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUriPath = CursorUtil.getColumnIndexOrThrow(_cursor, "uriPath");
          final int _cursorIndexOfIsSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "isSelected");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<ImageQueue> _result = new ArrayList<ImageQueue>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ImageQueue _item;
            final String _tmpUriPath;
            if (_cursor.isNull(_cursorIndexOfUriPath)) {
              _tmpUriPath = null;
            } else {
              _tmpUriPath = _cursor.getString(_cursorIndexOfUriPath);
            }
            final boolean _tmpIsSelected;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSelected);
            _tmpIsSelected = _tmp != 0;
            _item = new ImageQueue(_tmpUriPath,_tmpIsSelected);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
