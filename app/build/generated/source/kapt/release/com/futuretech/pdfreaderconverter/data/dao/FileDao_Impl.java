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
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.model.QueueImageConverter;
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
public final class FileDao_Impl implements FileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FileModel> __insertionAdapterOfFileModel;

  private final QueueImageConverter __queueImageConverter = new QueueImageConverter();

  private final EntityDeletionOrUpdateAdapter<FileModel> __deletionAdapterOfFileModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFileByTitle;

  private final SharedSQLiteStatement __preparedStmtOfDeleteFileById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllFiles;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFile;

  public FileDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFileModel = new EntityInsertionAdapter<FileModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `FileModel` (`title`,`timestamp`,`noOfImages`,`queueImage`,`isPdf`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FileModel value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getTimestamp() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTimestamp());
        }
        stmt.bindLong(3, value.getNoOfImages());
        final String _tmp = __queueImageConverter.fromArrayList(value.getImageQueueArrayList());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        final int _tmp_1 = value.isPdf() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        stmt.bindLong(6, value.getId());
      }
    };
    this.__deletionAdapterOfFileModel = new EntityDeletionOrUpdateAdapter<FileModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FileModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FileModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfDeleteFileByTitle = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM FileModel WHERE title = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteFileById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM FileModel WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllFiles = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from FileModel";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFile = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE FileModel SET title = ?,timestamp= ?,noOfImages= ?,queueImage= ?,isPdf= ? WHERE title LIKE ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFile(final FileModel file, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFileModel.insert(file);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public int deleteFile(final FileModel file) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfFileModel.handle(file);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFileByTitle(final String title) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFileByTitle.acquire();
    int _argIndex = 1;
    if (title == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, title);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteFileByTitle.release(_stmt);
    }
  }

  @Override
  public Object deleteFileById(final int id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFileById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteFileById.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllFiles(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllFiles.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllFiles.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object updateFile(final String title, final String timestamp, final int noOfImages,
      final ArrayList<ImageQueue> imagesList, final boolean isPdf, final String originalName,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFile.acquire();
        int _argIndex = 1;
        if (title == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, title);
        }
        _argIndex = 2;
        if (timestamp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, timestamp);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, noOfImages);
        _argIndex = 4;
        final String _tmp = __queueImageConverter.fromArrayList(imagesList);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 5;
        final int _tmp_1 = isPdf ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp_1);
        _argIndex = 6;
        if (originalName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, originalName);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateFile.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<FileModel>> getAllFiles() {
    final String _sql = "SELECT * from FileModel order by id desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"FileModel"}, false, new Callable<List<FileModel>>() {
      @Override
      public List<FileModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfNoOfImages = CursorUtil.getColumnIndexOrThrow(_cursor, "noOfImages");
          final int _cursorIndexOfImageQueueArrayList = CursorUtil.getColumnIndexOrThrow(_cursor, "queueImage");
          final int _cursorIndexOfIsPdf = CursorUtil.getColumnIndexOrThrow(_cursor, "isPdf");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<FileModel> _result = new ArrayList<FileModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FileModel _item;
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getString(_cursorIndexOfTimestamp);
            }
            final int _tmpNoOfImages;
            _tmpNoOfImages = _cursor.getInt(_cursorIndexOfNoOfImages);
            final ArrayList<ImageQueue> _tmpImageQueueArrayList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfImageQueueArrayList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfImageQueueArrayList);
            }
            _tmpImageQueueArrayList = __queueImageConverter.fromString(_tmp);
            final boolean _tmpIsPdf;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPdf);
            _tmpIsPdf = _tmp_1 != 0;
            _item = new FileModel(_tmpTitle,_tmpTimestamp,_tmpNoOfImages,_tmpImageQueueArrayList,_tmpIsPdf);
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
